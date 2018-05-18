# maoristemmer
Snowball stemmer for te kupu reo Māori, and derivative class for Lucene/Solr SnowballPorterFilterFactory 

## Introduction
This stemmer is written in Snowball (http://snowballstem.org) so it is portable across many platforms and uses, but the original intention was to autogenerate SnowballPorter stemmer classes for Apache Lucene and include in analyzer libraries so that DSpace and other webapps using Apache Solr for search can specify a Māori stemmer for field types in addition to English and other languages

## Quick start (Lucene libraries)
To test this stemmer out in Apache Solr 4.10.4 (eg DSpace 6):
1. Back up your existing Lucene Common Analyzers jar (probably somethig like `lucene-analyzers-common-4.10.4.jar`
1. Copy `lucene-analyzers-common-4.10.4-SNAPSHOT.jar` into your library / classpath
1. In your Solr schema, create a new `fieldType`, or modify an existing `fieldType` into include a SnowballPorterFilterFactory in both the index and query analyzers, with the language parameter set to "Maori" (no macron):
`<filter class="solr.SnowballPorterFilterFactory" language="Maori" protected="protwords.txt"/>`
1. Restart Tomcat / Solr and rebuild your Solr index
1. You should now be able to see stemming occurring if you test out queries / indexes in the dashboard, or POST new documents which use fields of the type you added the filter to.

Here's an example showing how this works for the passive verb ending '-tia' so that it is stemmed down to its active verb form, so a search for _waihangatia_ returns results matching _waihanga_ and vice versa:

![Alt text](example-passive-verb.jpg?raw=true "Title")
