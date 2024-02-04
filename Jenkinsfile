@Library('my-shared-library') _

pipeline{

    agent any

    parameters{

        choice(name: 'action', choices: 'create\ndelete', description: 'choose create/Destroy')
        string(name:'ImageName', description: "nom de docker build", defaultValue: 'javapp')
        string(name:'ImageTag', description: "tag de docker build", defaultValue: 'v1')
        string(name:'AppName', description: "nom d'application build", defaultValue: 'springboot')
       // string(name:'DockerHubUser', description: "nom d'application build", defaultValue: 'sdiawar')

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
      /*  stage('Unit Test maven'){

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
        }*/
        stage('Maven Build: maven'){
            when { expression{ params.action == 'create'  } }

            steps{
               script{

                  mvnBuild()
                }
            }
        }

        stage('Docker Image: Build'){
            when { expression{ params.action == 'create'  } }

            steps{
               script{

                  dockerbuild("${params.ImageName}", "${params.ImageTag}", "${params.AppName}")
                }
            }
        }
    }

      
}