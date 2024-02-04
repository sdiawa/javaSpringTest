def call (customImage = docker.build("${params.ImageName}:${params.ImageTag}")){

sh """
  docker rmi ${params.ImageName}:${params.ImageTag}
  docker rmi ${params.DockerHubUser}/${params.ImageName}:${params.ImageTag}

"""
}