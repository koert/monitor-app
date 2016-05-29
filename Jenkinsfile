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

    stage 'check'
    timeout(time: 15, unit: 'MINUTES') {
        sh "./gradlew check"
    }

    stage 'jacoco'
    timeout(time: 15, unit: 'MINUTES') {
        sh "./gradlew jacocoTestReport"
    }

    stage 'report'
    step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/*.xml'])
    step([$class: 'CheckStylePublisher', pattern: '**/reports/checkstyle/main.xml'])
    //step([$class: 'JacocoPublisher'])
    //step([$class: 'hudson.plugins.analysis.collector.AnalysisPublisher'])
    //step([$class: 'HtmlPublisher', reportDir: 'monitor-web/build/reports/jacoco/test/html'])
}
