def call(String ProjectName, String ImageName, String DockerHubUser) {
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageName} ."
}
