include_defs('//bucklets/gerrit_plugin.bucklet')

ITS_BASE = '//lib:its-base' if __standalone_mode__ \
  else '//plugins/its-base:its-base__plugin'

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
    ITS_BASE,
    align_path('its-bugzilla', '//lib:j2bugzilla'),
  ]
)

java_test(
  name = 'its-bugzilla_tests',
  srcs = glob(['src/test/java/**/*.java']),
  labels = ['its-bugzilla'],
  source_under_test = [':its-bugzilla__plugin'],
  deps = GERRIT_PLUGIN_API + [
    ':its-bugzilla__plugin',
    '//lib/easymock:easymock',
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
