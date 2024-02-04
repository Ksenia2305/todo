//package extension_test_class
//
//import io.kotest.core.extensions.TestCaseExtension
//import io.kotest.core.test.TestCase
//import io.kotest.core.test.TestResult
//
//open class RepeatOnFailureExtension : TestCaseExtension {
//    private val muxAttemptCount = 3
//    private var attemptCount = 1
//
//    override suspend fun intercept(testCase: TestCase, execute: suspend (TestCase) -> TestResult): TestResult {
//        var testResult: TestResult = execute(testCase)
//
//        while (!testResult.isSuccess && attemptCount < muxAttemptCount) {
//            println("Test rerun attempt #$attemptCount")
//            attemptCount += 1
//            testResult = execute(testCase)
//        }
//        return testResult
//    }
//}

