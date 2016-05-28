node {
    echo "start build"
    stage 'checkout'
    checkout scm

    stage 'build'
    timeout(time: 15, unit: 'MINUTES') {
        sh "./gradlew clean build"
    }

    stage 'test'
    timeout(time: 15, unit: 'MINUTES') {
        sh "./gradlew test"
    }

    stage 'jacoco'
    timeout(time: 15, unit: 'MINUTES') {
        sh "./gradlew jacocoTestReport"
    }

    stage 'report'
    step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/*.xml'])
}
