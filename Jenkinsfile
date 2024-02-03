@Library('my-shared-library') _

pipeline{

    agent any

    stages{
        
        stage('Git Checkout'){

            steps{
                gitCheckout(
                    branch: "main",                        
                    url: 'https://github.com/sdiawa/javaSpringTest.git'

                 )
            }
        }
        stage('Unit Test maven'){

            steps{
                
                script{

                    mvnTest()

                }

                 
            }
        }

        stage(' integration Test maven'){

            steps{
               script{

                    mvnIntegrationTest()

                }
            }
        }
    }

}