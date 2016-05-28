node {
    echo "start build"
    stage 'checkout'
    checkout scm

    stage 'build'
    timeout(time: 60, unit: 'MINUTES') {
        sh "./gradlew clean build"
    }

    stage 'test'
    timeout(time: 60, unit: 'MINUTES') {
        sh "./gradlew test"
    }

    stage 'report'
    step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/*.xml'])
}
