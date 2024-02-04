// def call(String project, String ImageTag, String hubUser){
    
//     sh """   
//      trivy image ${hubUser}/${project}:latest > scan.txt
//      cat scan.txt
//     """
// }

def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
    trivy image ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest > scan.txt
    cat scan.txt
    """
}

//def call(String project, String ImageTag, String hubUser){
    
def call (customImage = docker.build("${params.ImageName}:${params.ImageTag}")){

// Utilisez les credentials Docker Hub
withCredentials([usernamePassword(credentialsId: params.DockerHubCredentialsId, usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
    // Connexion à Docker Hub
    sh """
    trivy ${params.ImageName}:${params.ImageTag} ${params.DockerHubUser}/${params.ImageName}:${params.ImageTag} > scan.txt
    docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD

    // Ajoutez la commande docker tag
    docker tag ${params.ImageName}:${params.ImageTag} ${params.DockerHubUser}/${params.ImageName}:${params.ImageTag}

    // Poussez l'image avec le tag spécifié
    docker push ${params.DockerHubUser}/${params.ImageName}:${params.ImageTag}
    """
}

// Exécutez des commandes à l'intérieur du conteneur Docker (optionnel)
customImage.inside {
    // ...
  }
}