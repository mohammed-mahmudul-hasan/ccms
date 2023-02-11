package com.example.ccms;

class loginTest : LogInListener {
    private lateinit var successTask: Task<AuthResult>
    private lateinit var failureTask: Task<AuthResult>

    @Mock
    private lateinit val mAuth: FirebaseAuth
    private lateinit var loginTest: loginTest
    
    private var logInResult = UNDEF
    
    companion object {
        private const val SUCCESS = 1
        private const val FAILURE = -1
        private const val UNDEF = 0
    }
    
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        successTask = object : Task<AuthResult>() {
            override fun isComplete(): Boolean = true

            override fun isSuccessful(): Boolean = true
            // ...
            override fun addOnCompleteListener(executor: Executor,
                                onCompleteListener: OnCompleteListener<AuthResult>): Task<AuthResult> {
                onCompleteListener.onComplete(successTask)
                return successTask
            }
        }
      
        failureTask = object : Task<AuthResult>() {
            override fun isComplete(): Boolean = true

            override fun isSuccessful(): Boolean = false
            // ...
            override fun addOnCompleteListener(executor: Executor,
                                onCompleteListener: OnCompleteListener<AuthResult>): Task<AuthResult> {
                onCompleteListener.onComplete(failureTask)
                return failureTask
            }
        }
        loginTest = loginTest(mAuth, this)
    }
  
    @Test
    fun logInSuccess_test() {
        val email = "cool@cool.com"
        val password = "123456"
        Mockito.`when`(mAuth!!.signInWithEmailAndPassword(email, password))
                .thenReturn(successTask)
        logInModel!!.logIn(email, password)
        assert(logInResult == SUCCESS)
    }
    
    @Test
    fun logInFailure_test() {
        val email = "cool@cool.com"
        val password = "123_456"
        Mockito.`when`(mAuth!!.signInWithEmailAndPassword(email, password))
                .thenReturn(failureTask)
        accountModel!!.logIn(email, password)
        assert(logInResult == FAILURE)
    }
  
    override fun logInSuccess(email: String, password: String) {
        logInResult = SUCCESS
    }

    override fun logInFailure(exception: Exception, email: String, password: String) {
        logInResult = FAILURE
    }
}
