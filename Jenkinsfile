node {
    echo "start build"
    stage 'checkout'
    checkout scm

    stage 'build'
    sh "./gradlew clean build"

    stage 'build'
    sh "./gradlew test"

}
