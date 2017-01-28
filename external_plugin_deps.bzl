load("//tools/bzl:maven_jar.bzl", "maven_jar")

def external_plugin_deps():
  maven_jar(
    name = 'j2bugzilla',
    artifact = 'com.j2bugzilla:j2bugzilla:2.2.1',
    sha1 = '397e40c85bda1eb0a13bccf3cb7130d8f815290e',
  )

  maven_jar(
    name = 'xmlrpc-client',
    artifact = 'org.apache.xmlrpc:xmlrpc-client:3.1.3',
    sha1 = 'e486ad917028b52265610206fb5a1e2b5914b94b',
    visibility = [],
  )

  maven_jar(
    name = 'xmlrpc-common',
    artifact = 'org.apache.xmlrpc:xmlrpc-common:3.1.3',
    sha1 = '415daf1f1473a947452588906dc9f5b3575fb44d',
    visibility = [],
  )

  maven_jar(
    name = 'ws-commons-util',
    artifact = 'org.apache.ws.commons.util:ws-commons-util:1.0.2',
    sha1 = '3f478e6def772c19d1053f61198fa1f6a6119238',
    visibility = [],
  )

  maven_jar(
    name = 'xml-apis',
    artifact = 'xml-apis:xml-apis:1.0.b2',
    sha1 = '3136ca936f64c9d68529f048c2618bd356bf85c9',
  )
