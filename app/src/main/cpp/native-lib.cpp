#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jnidemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnidemo_MainActivity_additionFromJNI(JNIEnv *env, jobject thiz, jint num1,
                                                      jint num2) {
//    std::int64_t res = num1+num2;
    return num1 + num2;
}
//extern "C"
//JNIEXPORT jint JNICALL
//Java_com_example_jnidemo_MainActivity_additionFromJNI(JNIEnv *env, jobject thiz, jint num1,
//                                                      jint num2) {
//    return env->;
//}