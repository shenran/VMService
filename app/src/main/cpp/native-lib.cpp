#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_cn_ishenran_vm_fuji_vmservice_SettingActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
