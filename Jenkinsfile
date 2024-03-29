@Library('my-shared-library') _

pipeline{

    agent any

    parameters{

        choice(name: 'action', choices: 'create\ndelete', description: 'choose create/Destroy')
        string(name:'ImageName', description: "Entrez : le nom de docker image à builder", defaultValue: 'javapp')
        string(name:'ImageTag', description: "Entrez : le tag de docker image à builder", defaultValue: 'v1')
        string(name:'PortApp', description: "Entrez : le port ", defaultValue: '9090:8080')
        string(name:'AppName', description: "Entrez : le nom d'application ", defaultValue: 'springboot')
        string(name:'DockerHubUser', description: "Entrez : le user du repot DockerHub ", defaultValue: 'sdiawar')
        string(name:'DockerHubCredentialsId', description: "Entrez : le DockerHub CredentialsId", defaultValue: 'sdiawa')
        

    }

    stages{
     
        stage('Git Checkout'){
          when { expression{ params.action == 'create'  } }
            steps{
                gitCheckout(
                    branch: "main",                        
                    url: 'https://github.com/sdiawa/javaSpringTest.git'

                 )
            }
        }
        stage('Unit Test maven'){

            when { expression{ params.action == 'create'  } }

            steps{
                
                script{

                    mvnTest()

                }
                 
            }
        }

        stage('Integration Test maven'){
            when { expression{ params.action == 'create'  } }

            steps{
               script{

                    mvnIntegrationTest()

                }
            }
        }
        stage('Static code  analysis: Sonarq'){
            when { expression{ params.action == 'create'  } }

            steps{
               script{

                    def SonarQubecredentialsId = 'sonarq-api'
                    statiCodeAnalysis(SonarQubecredentialsId)
                }
            }
        }
        stage('QualityGate Status Check: Sonarq'){
            when { expression{ params.action == 'create'  } }

            steps{
               script{

                    def SonarQubecredentialsId = 'sonarq-api'
                    QualityGateStatus(SonarQubecredentialsId)
                }
            }
        }
        stage('Maven Build: maven'){
            when { expression{ params.action == 'create'  } }

            steps{
               script{

                  mvnBuild()
                }
            }
        }

        stage('Build Docker Image') {
            when { expression{ params.action == 'create'  } }
            steps{
               script{        

                  dockerBuild()
                }
            }
        }
        stage('Docker Scan Image: trivy') {
            when { expression{ params.action == 'create'  } }
            steps{
               script{        

                  dockerImageScan()
                }
            }
        }
        stage('Docker push Image: dockerhub') {
            when { expression{ params.action == 'create'  } }
            steps{
               script{        

                  dockerImagePush()
                }
            }
        }
           stage('Run Docker Container : Run') {
            when { expression{ params.action == 'create'  } }
            steps{
               script{        

                  dockerRun()
                }
            }
        }
      /*  stage('Docker Image CleanUp: CleanUp dockerhub') {
            when { expression{ params.action == 'create'  } }
            steps{
               script{        

                  dockerImageCleanup()
                }
            }
        }*/
   }
}
