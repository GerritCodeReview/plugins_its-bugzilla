package(default_visibility = ["//visibility:public"])

java_library(
  name = 'j2bugzilla',
  runtime_deps = [':xmlrpc-client'],
  exports = ["@j2bugzilla//jar"],
)

java_library(
  name = 'xmlrpc-client',
  runtime_deps = [':xmlrpc-common'],
  exports = ["@xmlrpc-client//jar"],
)

java_library(
  name = 'xmlrpc-common',
  runtime_deps = [':ws-commons-util'],
  exports = ["@xmlrpc-common//jar"],
)

java_library(
  name = 'ws-commons-util',
  runtime_deps = [':xml-apis'],
  exports = ["@ws-commons-util//jar"],
)

java_library(
  name = 'xml-apis',
  exports = ["@xml-apis//jar"],
)
