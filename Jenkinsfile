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
				sh "cd Apply-For-Me-UI && sudo npm i --force && CI=false npm run build"
			} 
        }
        stage("build backend"){

			steps {
                sh "cd Apply-For-Me-Api && sudo mvn install"
            }
        }
		stage("deploy") {
		
			steps {
				sh "sudo cp -r ${WORKSPACE}/applyforme.web /home/johnoni/"

				// sh "sudo systemctl restart tropicalweatherf.service"
				// sh "sudo systemctl restart tropicalweatherb.service"
            }
			
	    }
	}
}

