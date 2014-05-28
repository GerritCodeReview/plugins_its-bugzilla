gerrit_plugin(
  name = 'its-bugzilla',
  srcs = glob(['src/main/java/**/*.java']),
  resources = glob(['src/main/**/*']),
  manifest_entries = [
    'Gerrit-PluginName: its-bugzilla',
    'Gerrit-Module: com.googlesource.gerrit.plugins.hooks.bz.BugzillaModule',
    'Gerrit-InitStep: com.googlesource.gerrit.plugins.hooks.bz.InitBugzilla',
    'Gerrit-ReloadMode: reload',
    'Implementation-Title: Plugin its-bugzilla',
    'Implementation-URL: https://www.wikimediafoundation.org',
  ],
  deps = [
    '//plugins/its-base:its-base__plugin',
    '//plugins/its-bugzilla/lib:j2bugzilla',
  ],
)

java_test(
  name = 'its-bugzilla_tests',
  srcs = glob(['src/test/java/**/*.java']),
  labels = ['its-bugzilla'],
  source_under_test = [':its-bugzilla__plugin'],
  deps = [
    ':its-bugzilla__plugin',
    '//gerrit-plugin-api:lib',
    '//lib:easymock',
    '//lib:guava',
    '//lib/guice:guice',
    '//lib/jgit:jgit',
    '//lib:junit',
    '//lib/log:api',
    '//lib/log:impl_log4j',
    '//lib/log:log4j',
    '//lib:powermock-api-easymock',
    '//lib:powermock-api-support',
    '//lib:powermock-core',
    '//lib:powermock-module-junit4',
    '//lib:velocity',
  ],
)
