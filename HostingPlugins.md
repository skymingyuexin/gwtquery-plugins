



# Introduction #
We encourage plugin developers to create and host the plugins on googlecode repository. This makes it easier for the community to help you more easily, as well as to have the community benefit from the plugin.

If you still don't know how the [gquery](http://code.google.com/p/gwtquery) plugin system works, you should read the [WritingPlugins](http://code.google.com/p/gwtquery/wiki/WritingPlugins) page.

There are two options to send a plugin to this project:
  1. Simply attach a file containing all your code to the issue system and announce it to the mailing list.
  1. Or the official procedure which needs a few knowledge of subversion and maven.

# License #
All plugins hosted in this project must have a valid LICENSE file  compatible with the license of the gwtquery project. We recommend MIT, Apache-v2.0, or GPLv3 based on your personal philosophy.

Obviously you can change the copyright in the header of the LICENSE file putting whatever your want: your Name, Company, Organization, or just 'The gwtquery plugins team'.

# Adding a plugin without knowing maven #
In this case, you need the collaboration of a gwtquery-plugins committer.

  * Open a new ticket in the issue system http://code.google.com/p/gwtquery-plugins/issues/list
  * Describe your plugin, and anything that the user needs to know to use the plugin in the ticket comments.
  * Attach to the issue a compressed file with the code. Note that you could also attach just the .jar file, since a gwt library contains the sources and the public stuff.
  * Check that your file includes a valid [LICENSE](http://code.google.com/p/gwtquery/source/browse/trunk/LICENSE) file.
  * Send a mail to the [gwtquery](http://groups.google.com/group/gwtquery) mailing list asking for a sponsor to release the plugin.

Finally when the plugin was released, you would be added as a contributor in the [project people list](http://code.google.com/p/gwtquery-plugins/people/list)

# Adding a plugin using maven and subversion #

## Request hosting ##
Simply subscribe to the gwtquery mailing list and send an email to the list asking for commit access, describing briefly your plugin, and specifying your gmail user id .

## Steps to create the new plugin with maven ##
The following procedure describes how to create a new plugin from scratch using the gwtquery-plugin-archetype hosted on the maven central repository.

  * Assuming your have java and maven (2.2.1) installed, and the command mvn is in your path, just run:
```
  mvn archetype:generate  \
      -DarchetypeGroupId=com.googlecode.gwtquery \
      -DarchetypeArtifactId=gquery-plugin-archetype \
      -DarchetypeVersion=0.3 \
      -DartifactId=myplugin -DpluginName=MyPlugin
```
where `artifactId` represents the lower-case name of your plugin, and `pluginName` is the camelized name of it.
  * The generated project has everything to start a new plugin: license, code, sample and test. Use this code as reference, and maintain the structure.
  * Change to the plugin folder and check that everything is all right:
```
  cd myplugin
  mvn install
  cd sample
  mvn gwt:run
```

## Importing the project in eclipse ##
The archetype generates a project ready to use in eclipse, but before importing it you have to install the following plugins:
  * Google plugin for eclipse (update-site: http://dl.google.com/eclipse/plugin/3.6, change to 3.5 for galileo)
  * Sonatype Maven plugin (update-site: http://m2eclipse.sonatype.org/site/m2e)
  * Subversion plugin (update-site: http://subclipse.tigris.org/update_1.6.x)
Then you can import the project in your eclipse workspace:
  * File -> Import -> General -> Existing Projects into Workspace
After this you should be able to run the project in development mode and to run the gwt test unit.
  * Right click on the project -> Run as -> Web Application
  * Right click on the test class -> Run as -> GWT JUnit Test

## Code style conventions ##
Although it is not mandatory, but like gwtquery does, all the code in the plugins repository should match the [google-web-toolkit code styling rules](http://code.google.com/intl/es/webtoolkit/makinggwtbetter.html#codestyle)

Also good test-units and javadocs are welcome.

## Commit your plugin to the repository ##
Check that the LICENSE file is in the root folder of your plugin.

Note that previously to send anything to the repository you had to ask for commit access.

The password for google code is different to the one you use to read gmail.

If your browser is logged in gmail, you could see your password visiting this url:  https://code.google.com/hosting/settings.

Please, be sure that the tests run before committing anything, and make good comments to your commits.

  1. Importing the project using the subversion plugin in eclipse
```
  Right click on the project -> Team -> Share Project -> SVN ->
  https://gwtquery-plugins.googlecode.com/svn/trunk/ -> Use specified folder name ->
  helloworld -> SVN Perspective -> Right click on the project -> Commit
```

  1. Importing the project using the `svn` command
```
 mvn clean
 cd myplugin
 svn mkdir --parents -m "Initial import." \
   https://gwtquery-plugins.googlecode.com/svn/trunk/myplugin
 svn checkout https://gwtquery-plugins.googlecode.com/svn/trunk/myplugin .
 svn --auto-props add * .settings .project .classpath
 svn commit -m 'Initial import'
```

## Releasing your plugin ##
Use maven to release the plugin, but previously be sure that your $HOME/.m2/settings.xml file has the information needed to authenticate in googlecode site:
```
  <server>
    <id>googlecode</id>
    <username>your_username</username>
    <password>your_password</password>
  </server>
```
Also add to the parent pom your developer information.
```
  <developers>
    <developer>
      <id>your_id</id>
      <name>your full name</name>
      <email>your email</email>
      <organization>your organization</organization>
    </developer>
  </developers>
```

Remove the -SNAPSHOT sufix from your pom files

Next, verify that there are no local changes pending to commit to svn

Finally execute these commands to publish the artifact in the download page and in the project maven repository
```
  mvn clean 
  mvn package
  mvn deploy
```

Finally increase the version in your pom files to start a new development interation.

# Maintain the plugin #
  * Be in touch with the people who is using your plugin, and the users of the gwtquery library participating in the gwtquery mailing list.
  * Read the issues list periodically  and fix those issues related with your plugin.
  * Create and maintain a wiki page with the name of your plugin explaining how to use it, and put links to examples and javadocs.
  * Release the plutin as soon as it is ready to use, after adding a new feature or a fix.
# Hosting Demos #
It is a good idea maintain a web page showing the plugin in action.
You can use the svn repository to store and put the static stuff of the demo (html, js, images, etc).
  * Create a folder in the plugin root called `demos`
  * Put the compiled gwt application there
  * Before committing the folder, set the adequate svn:mimetype of html files.
```
 svn propset svn:mimetype text/html demos/my_plugin_demo.html
```
  * Finally put the link to the page in the wiki page of your plugin.
```
 http://gwtquery-plugins.googlecode.com/svn/trunk/my_plugin/demos/my_plugin_demo.html
```