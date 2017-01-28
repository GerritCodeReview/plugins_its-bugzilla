load("//tools/bzl:junit.bzl", "junit_tests")
load(
    "//tools/bzl:plugin.bzl",
    "gerrit_plugin",
    "PLUGIN_DEPS",
    "PLUGIN_TEST_DEPS",
)

gerrit_plugin(
    name = "its-bugzilla",
    srcs = glob(["src/main/java/**/*.java"]),
    manifest_entries = [
        "Gerrit-Module: com.googlesource.gerrit.plugins.its.bugzilla.BugzillaModule",
        "Gerrit-InitStep: com.googlesource.gerrit.plugins.its.bugzilla.InitBugzilla",
        "Gerrit-ReloadMode: reload",
        "Implementation-Title: Bugzilla ITS Plugin",
        "Implementation-URL: https://www.wikimediafoundation.org",
    ],
    resources = glob(["src/main/**/*"]),
    deps = [
        "//plugins/its-base",
        "//plugins/its-bugzilla/lib:j2bugzilla",
    ],
)

junit_tests(
    name = "its_bugzilla_tests",
    srcs = glob(["src/test/java/**/*.java"]),
    tags = ["its-bugzilla"],
    deps = PLUGIN_DEPS + PLUGIN_TEST_DEPS + [
        ":its-bugzilla__plugin",
        "//plugins/its-base:its-base",
        "//plugins/its-base:its-base_tests-utils",
    ],
)
