gerrit_plugin(
  name = 'its-bugzilla',
  srcs = glob(['src/main/java/**/*.java']),
  resources = glob(['src/main/resources/**/*']),
  manifest_entries = [
    'Gerrit-Module: com.googlesource.gerrit.plugins.hooks.bz.BugzillaModule',
    'Gerrit-InitStep: com.googlesource.gerrit.plugins.hooks.bz.InitBugzilla',
    'Gerrit-ReloadMode: reload',
    'Implementation-Title: Bugzilla ITS Plugin',
    'Implementation-URL: https://www.wikimediafoundation.org',
  ],
  deps = [
    ':its-base_stripped',
    '//plugins/its-bugzilla/lib:j2bugzilla',
  ],
)

def strip_jar(
    name,
    src,
    excludes = [],
    visibility = [],
  ):
  name_zip = name + '.zip'
  genrule(
    name = name_zip,
    cmd = 'cp $SRCS $OUT && zip -qd $OUT ' + ' '.join(excludes),
    srcs = [ src ],
    deps = [ src ],
    out = name_zip,
    visibility = visibility,
  )
  prebuilt_jar(
    name = name,
    binary_jar = ':' + name_zip,
    visibility = visibility,
  )

strip_jar(
  name = 'its-base_stripped',
  src = '//plugins/its-base:its-base',
  excludes = [
    'Documentation/about.md',
    'Documentation/build.md',
    'Documentation/config-connectivity.md',
    'Documentation/config-rulebase-plugin-actions.md',
  ]
)

java_test(
  name = 'its-bugzilla_tests',
  srcs = glob(['src/test/java/**/*.java']),
  labels = ['its-bugzilla'],
  source_under_test = [':its-bugzilla__plugin'],
  deps = [
    ':its-bugzilla__plugin',
    '//plugins/its-base:its-base_tests-utils',
    ':its-base_stripped',
    '//gerrit-plugin-api:lib',
    '//lib/easymock:easymock',
    '//lib:guava',
    '//lib/guice:guice',
    '//lib/jgit:jgit',
    '//lib:junit',
    '//lib/log:api',
    '//lib/log:impl_log4j',
    '//lib/log:log4j',
    '//lib/powermock:powermock-api-easymock',
    '//lib/powermock:powermock-api-support',
    '//lib/powermock:powermock-core',
    '//lib/powermock:powermock-module-junit4',
  ],
)
