node {
  stage "Checkout" {
    git url: "https://github.com/rozyhead/haru.git"
  }

  stage "Build" {
    sh "./gradlew build"
  }

  stage "Archive" {
    archiveArtifacts artifacts: "build/libs/*.jar"
  }
}
