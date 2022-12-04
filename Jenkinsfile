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
				sh "cd applyforme.web"
				sh "cd applyforme.web"
				sh "cd Apply-For-Me-UI && sudo npm i --force"

				// sh "sudo mkdir /var/lib/jenkins/workspace/applyforme/Apply-For-Me-UI/node_modules/.cache"
				sh "cd Apply-For-Me-UI && CI=false sudo npm run build"
				sh "pwd"
			} 
        }
        // stage("build backend"){

		// 	steps {
        //         sh "cd Apply-For-Me-Api"
		// 		sh "cd Apply-For-Me-Api && sudo mvn -B package --file pom.xml"
        //     }
        // }

		stage("deploy") {
		
			steps {
				sh "sudo cp -r ${WORKSPACE}/applyforme/* /home/johnoni/"
				// sh "sudo systemctl restart nickstersz.service"

				// sh "sudo systemctl restart tropicalweatherf.service"
				// sh "sudo systemctl restart tropicalweatherb.service"
            }
			
	    }
	}
}

