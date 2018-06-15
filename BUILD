load("//tools/bzl:junit.bzl", "junit_tests")
load(
    "//tools/bzl:plugin.bzl",
    "PLUGIN_DEPS",
    "PLUGIN_TEST_DEPS",
    "gerrit_plugin",
)

gerrit_plugin(
    name = "its-bugzilla",
    srcs = glob(["src/main/java/**/*.java"]),
    manifest_entries = [
        "Gerrit-PluginName: its-bugzilla",
        "Gerrit-Module: com.googlesource.gerrit.plugins.its.bugzilla.BugzillaModule",
        "Gerrit-InitStep: com.googlesource.gerrit.plugins.its.bugzilla.InitBugzilla",
        "Gerrit-ReloadMode: reload",
        "Implementation-Title: Bugzilla ITS Plugin",
        "Implementation-URL: https://www.wikimediafoundation.org",
    ],
    resources = glob(["src/main/resources/**/*"]),
    deps = [
        "//plugins/its-base",
        "@j2bugzilla//jar",
    ],
)

junit_tests(
    name = "its_bugzilla_tests",
    srcs = glob(["src/test/java/**/*.java"]),
    tags = ["its-bugzilla"],
    deps = [
        "its-bugzilla__plugin_test_deps",
    ],
)

java_library(
    name = "its-bugzilla__plugin_test_deps",
    testonly = 1,
    visibility = ["//visibility:public"],
    exports = PLUGIN_DEPS + PLUGIN_TEST_DEPS + [
        ":its-bugzilla__plugin",
        "//plugins/its-base:its-base",
        "//plugins/its-base:its-base_tests-utils",
    ],
)
