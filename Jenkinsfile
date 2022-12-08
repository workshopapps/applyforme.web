pipeline {

	agent any
	stages {

        stage("Get repo"){

			steps {
				sh "rm -rf ${WORKSPACE}/applyforme.web"
				sh "git clone https://github.com/workshopapps/applyforme.web.git"
			}
		}

        stage("build frontend"){

			steps {

				dir('applyforme.web/Apply-For-Me-UI') {
                    sh "sudo npm install"
                    sh "sudo CI=false npm run build"
                }
			}
        }

        stage("build backend"){

            steps {

				dir('applyforme.web/Apply-For-Me-Api') {
                    sh "mvn install"
                    sh "sudo mvn -B package --file pom.xml"
                }
			}

		// 	steps {
        //         sh "cd Apply-For-Me-Api"
		// 		sh "cd Apply-For-Me-Api && sudo mvn -B package --file pom.xml"
        //     }
        }

		stage("deploy") {
		
			steps {
				// sh "sudo cp -r /var/lib/jenkins/workspace/applyforme/ /home/johnoni/"
                sh "sudo cp -r ${WORKSPACE}/applyforme.web /home/johnoni/"
				sh "sudo systemctl restart pm2-victoradesanya.service"
				sh "sudo systemctl restart applyformeBE-johnoni.service"
            }
	    }
	}
}

