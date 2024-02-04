@Library('my-shared-library') _

pipeline{

    agent any

    parameters{

        choice(name: 'action', choices: 'create\ndelete', description: 'choose create/Destroy')

    }

    stages{
 
        when { expression{ param.action == 'create'  } }
        stage('Git Checkout'){

            steps{
                gitCheckout(
                    branch: "main",                        
                    url: 'https://github.com/sdiawa/javaSpringTest.git'

                 )
            }
        }
        stage('Unit Test maven'){

            when { expression{ param.action == 'create'  } }

            steps{
                
                script{

                    mvnTest()

                }

                 
            }
        }

        stage('Integration Test maven'){
            when { expression{ param.action == 'create'  } }

            steps{
               script{


                    mvnIntegrationTest()

                }
            }
        }
        stage('Static code  analysis: Sonarq'){
            when { expression{ param.action == 'create'  } }

            steps{
               script{

                    
                    statiCodeAnalysis()

                }
            }
        }
    }

}