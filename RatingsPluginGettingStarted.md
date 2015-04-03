

# Plugin Information #

| **Plugin name** |Ratings|
|:----------------|:------|
| **Latest release** |[1.0](http://code.google.com/p/gwtquery-plugins/downloads/detail?name=Ratings-plugin-1.0.jar)|
| **Latest release date** |Sep 08, 2010|
| **Maintainer** |[GQuery Team](http://code.google.com/p/gwtquery/people/list)|
| **Issues tracking** | [Open issues](http://code.google.com/p/gwtquery-plugins/issues/list?can=2&q=label%3ARatings)|

This plugin is a gwt port of the [jQuery Star Rating Plugin](http://www.fyneworks.com/jquery/star-rating/)

## What does it do? ##
The Ratings plugin is a plugin for the [GwtQuery](http://code.google.com/p/gwtquery/) library that creates a non-obstrusive star rating control based on a set of radio input boxes.

  * It turns a collection of radio boxes into a neat star-rating control.
  * It creates the interface based on standard form elements, which means the basic functionality will still be available even if Javascript is disabled.
  * In read only mode (using the 'readOnly' option or `disabled` property), the plugin is a neat way of displaying star-like values without any additional code.
  * The title of each star indicates the value you can set.
  * The cancel button allows uncheck the inputs.

# Changelog #
## v1.0 ##
  * First release (moved from gwtquery repo to gquery-plugins).
  * Many fixes

# Using the plugin #

## Configuration ##

First of all you have to include the library in the classpath of your project.
  * If you are using `ant` normally it is enough to download the library from the [downloads page](http://code.google.com/p/gwtquery-plugins/downloads/list) and put it in the war/WEB-INF/lib folder.

  * If you use `maven`, you have to add these blocks to your pom.xml
```
   <repositories>
        <repository>
         <id>plugins</id>
         <url>http://gwtquery-plugins.googlecode.com/svn/mavenrepo</url>
       </repository>
   </repositories>

   <build>
    <dependencies>
        <dependency>
            <groupId>com.googlecode.gwtquery.plugins</groupId>
            <artifactId>ratings-plugin</artifactId>
            <scope>compile</scope>
            <version>1.0</version>
        </dependency>
    </dependencies>
   </build>
```

Then you need to inherit the plugin in your Module.gwt.xml file:
```
  <inherits name='gwtquery.plugins.ratings.Ratings'/>
```

And finally, as with all gwtQuery plugins, just call the Ratings plugin like that :
```
import static gwtquery.plugins.ratings.client.ratings.Ratings;
...
$("input.star").as(Ratings).rate()
```

It enhances all inputs in your document, replacing them with nice starts.



## How do I use it? ##
  * Just add the `star` class to your radio inputs.
```
  <input name="star1" type="radio" class="star" value="1"/>
  <input name="star1" type="radio" class="star" value="2"/>
  <input name="star1" type="radio" class="star" value="3"/>
  <input name="star1" type="radio" class="star" value="4"/>
  <input name="star1" type="radio" class="star" value="5"/>
```
  * Use the `checked` property to specify the initial/default value of the control
```
  <input name="star2" type="radio" class="star" value="bad"/>
  <input name="star2" type="radio" class="star" value="acceptable"/>
  <input name="star2" type="radio" class="star" value="good" checked="checked"/>
  <input name="star2" type="radio" class="star" value="cool"/>
  <input name="star2" type="radio" class="star" value="excellent"/>
```
  * Use the `disabled` property to use a control for display purposes only
```
  <input name="star3" type="radio" class="star" disabled="disabled"/>
  <input name="star3" type="radio" class="star" disabled="disabled"/>
  <input name="star3" type="radio" class="star" disabled="disabled" checked="checked"/>
  <input name="star3" type="radio" class="star" disabled="disabled"/>
  <input name="star3" type="radio" class="star" disabled="disabled"/>
```
  * Use the `class` property to configure star divisions.
```
  <input name="adv1" type="radio" class="star {split:4}" value="0.00"/>
  <input name="adv1" type="radio" class="star {split:4}" value="0.25"/>
  <input name="adv1" type="radio" class="star {split:4}" value="0.50"/>
  <input name="adv1" type="radio" class="star {split:4}" value="0.75"/>
  <input name="adv1" type="radio" class="star {split:4}" value="1.00"/>
  <input name="adv1" type="radio" class="star {split:4}" value="1.25"/>
  <input name="adv1" type="radio" class="star {split:4}" value="1.50"/>
  <input name="adv1" type="radio" class="star {split:4}" value="1.75" checked="checked"/>
  <input name="adv1" type="radio" class="star {split:4}" value="2.00"/>
  <input name="adv1" type="radio" class="star {split:4}" value="2.25"/>
  <input name="adv1" type="radio" class="star {split:4}" value="2.50"/>
  <input name="adv1" type="radio" class="star {split:4}" value="2.75"/>
  <input name="adv1" type="radio" class="star {split:4}" value="3.00"/>
  <input name="adv1" type="radio" class="star {split:4}" value="3.25"/>
  <input name="adv1" type="radio" class="star {split:4}" value="3.50"/>
  <input name="adv1" type="radio" class="star {split:4}" value="3.75"/>
```

# Samples #

To better understand the plugin, take a look to the example:
  * http://gwtquery-plugins.googlecode.com/svn/trunk/ratings/demos/Ratings/RatingsSample.html