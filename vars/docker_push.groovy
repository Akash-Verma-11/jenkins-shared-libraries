def call(String imageName, String imageTag, String dockerHubUser) {
  withCredentials([usernamePassword(
    credentialsId: "dockerHubCred",
    usernameVariable: "dockerHubUser",
    passwordVariable: "dockerHubPass"
  )]) {
    sh "echo ${env.dockerHubPass} | docker login -u ${env.dockerHubUser} --password-stdin"
    sh "docker image tag notes-app:latest ${env.dockerHubUser}/notes-app:latest"
    sh "docker push ${env.dockerHubUser}/notes-app:latest"
  }
}
