#include <jni.h>
#include <string>
#include <android/log.h>

//extern "C" JNIEXPORT jstring JNICALL
//Java_com_example_jnidemo_MainActivity_stringFromJNI(
//        JNIEnv* env,
//        jobject /* this */) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
//}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnidemo_MainActivity_additionFromJNI(JNIEnv *env, jobject thiz, jint num1,
                                                      jint num2) {

    return num1 + num2;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnidemo_MainActivity_subtractionFromJNI(JNIEnv *env, jobject thiz, jint num1,
                                                         jint num2) {
    return num1 - num2;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnidemo_MainActivity_sumOfArrayFromJNI(JNIEnv *env, jobject thiz,
                                                        jintArray int_array) {
    jint *arr = env->GetIntArrayElements(int_array, nullptr);
    jint res = 0;
    jint size = env->GetArrayLength(int_array);
    for (int i = 0; i < size; ++i) {
        res += arr[i];
    }
    env->ReleaseIntArrayElements(int_array,arr,NULL);
    __android_log_write(ANDROID_LOG_DEBUG,"LOG_FROM_JNI_FUNCTION","Sum Of Array");
    return res;
}