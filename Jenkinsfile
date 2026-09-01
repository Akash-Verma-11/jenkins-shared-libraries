@Library('Shared') _
pipeline {
    agent {label "agent-1"}
    stages{
        stage("hello") {
            steps {
                script{
                    hello()
                }
                echo "from shared library"
            }
        }
        stage("Code") {
            steps {
                script {
                    gitclone("https://github.com/Akash-Verma-11/django-notes-app.git","main")
                }
            }
        }
        stage("Build") {
            steps {
                script {
                    docker_build("notes-app","latest","akash11v")
                }
            }
        }
        stage("Push") {
            steps {
                script {
                    docker_push("notes-app","latest","akash11v")
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    echo "this is deploying stage"
                    sh "docker run -d -p 8080:8080 --name notes-app notes-app:latest"
                }
            }
        }
    }
}
