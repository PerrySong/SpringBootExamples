<head>
<title>Getting Started · Building a RESTful Web Service with Spring Boot Actuator</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1, user-scalable=no" id="Viewport" name="viewport">
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon-ca31b78daf0dd9a106bbf3c6d87d4ec7.png">
<link href="https://fonts.googleapis.com/css?family=Varela+Round|Montserrat:400,700" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/css/main-bc256dba5f9d253d6425441ccfb82576.css">
<script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script><script async="" src="https://www.googletagmanager.com/gtm.js?id=GTM-KZM7GF6"></script><script src="/jspm_packages/system-eccc019329febb5a1b06bde008ca5614.js"></script>
<script>
    System.config({baseURL: "/b13d3a0"});
  </script>
<script src="/config-5a675c9cddea3a5f55b71416e67d47d6.js"></script>
<script>
      System.import('app/main.js')
  </script>
<meta content="7qGntFPD9lWAVCtUu5U77v4l68PsTHf6xpzgjQv2j2M" name="google-site-verification">

<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
    new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
      j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
      'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
    })(window,document,'script','dataLayer','GTM-KZM7GF6');</script>

<link rel="stylesheet" type="text/css" href="/css/gsguide-cce08ab7a9f46db88819a14148e45bad.css">

<meta property="og:title" content="Building a RESTful Web Service with Spring Boot Actuator">
<meta property="og:image" content="/img/spring-by-pivotal-9066b55828deb3c10e27e609af322c40.png">
<meta property="og:description" content="this guide is designed to get you productive as quickly as possible and using the latest Spring project releases and techniques as recommended by the Spring team">
</head>

<main class="main-body--wrapper">
<div class="row-fluid">
<div class="span8 mobile-left-pane">
<div class="content--title desktop-only">Getting Started</div>
<article class="content--container">
<h1 class="title">Building a RESTful Web Service with Spring Boot Actuator</h1>
<div class="article-body"><div class="paragraph">
<p><a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready">Spring Boot Actuator</a> is a sub-project of Spring Boot. It adds several production grade services to your application with little effort on your part. In this guide, you’ll build an application and then see how to add these services.</p>
</div>
<div class="sect1">
<h2 id="_what_you_ll_build">What you’ll build</h2>
<div class="sectionbody">
<div class="paragraph">
<p>This guide will take you through creating a "hello world" <a href="/understanding/REST">RESTful web service</a> with Spring Boot Actuator. You’ll build a service that accepts an HTTP GET request:</p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-0" data-clipboard-target="#code-block-0"></button><pre class="prettyprint highlight" id="code-block-0"><code class="language-sh" data-lang="sh"><span class="pln">$ curl http</span><span class="pun">:</span><span class="com">//localhost:9000/hello-world</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>It responds with the following <a href="/understanding/JSON">JSON</a>:</p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-1" data-clipboard-target="#code-block-1"></button><pre class="prettyprint highlight" id="code-block-1"><code class="language-json" data-lang="json"><span class="pun">{</span><span class="str">"id"</span><span class="pun">:</span><span class="lit">1</span><span class="pun">,</span><span class="str">"content"</span><span class="pun">:</span><span class="str">"Hello, World!"</span><span class="pun">}</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>There are also many features added to your application out-of-the-box for managing the service in a production (or other) environment. The business functionality of the service you build is the same as in <a href="/guides/gs/rest-service">Building a RESTful Web Service</a>. You don’t need to use that guide to take advantage of this one, although it might be interesting to compare the results.</p>
</div>
<div class="sect2">
<h3 id="_what_you_ll_need">What you’ll need</h3>
<div class="ulist">
<ul>
<li> <p>About 15 minutes</p> </li>
<li> <p>A favorite text editor or IDE</p> </li>
<li> <p><a href="http://www.oracle.com/technetwork/java/javase/downloads/index.html">JDK 1.8</a> or later</p> </li>
<li> <p><a href="http://www.gradle.org/downloads">Gradle 4+</a> or <a href="https://maven.apache.org/download.cgi">Maven 3.2+</a></p> </li>
<li> <p>You can also import the code straight into your IDE:</p>
<div class="ulist">
<ul>
<li> <p><a href="/guides/gs/sts">Spring Tool Suite (STS)</a></p> </li>
<li> <p><a href="/guides/gs/intellij-idea/">IntelliJ IDEA</a></p> </li>
</ul>
</div> </li>
</ul>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_how_to_complete_this_guide">How to complete this guide</h2>
<div class="sectionbody">
<div class="paragraph">
<p>Like most Spring <a href="/guides">Getting Started guides</a>, you can start from scratch and complete each step, or you can bypass basic setup steps that are already familiar to you. Either way, you end up with working code.</p>
</div>
<div class="paragraph">
<p>To <strong>start from scratch</strong>, move on to <a href="#scratch">Build with Gradle</a>.</p>
</div>
<div class="paragraph">
<p>To <strong>skip the basics</strong>, do the following:</p>
</div>
<div class="ulist">
<ul>
<li> <p><a href="https://github.com/spring-guides/gs-actuator-service/archive/master.zip">Download</a> and unzip the source repository for this guide, or clone it using <a href="/understanding/Git">Git</a>: <code>git clone <a href="https://github.com/spring-guides/gs-actuator-service.git" class="bare">https://github.com/spring-guides/gs-actuator-service.git</a></code></p> </li>
<li> <p>cd into <code>gs-actuator-service/initial</code></p> </li>
<li> <p>Jump ahead to <a href="#initial">Create a representation class</a>.</p> </li>
</ul>
</div>
<div class="paragraph">
<p><strong>When you’re finished</strong>, you can check your results against the code in <code>gs-actuator-service/complete</code>.</p>
</div>
</div>
</div>
<div class="sect1 reveal-gradle">
<h2 id="reveal-gradle">Build with Gradle</h2>
<div class="sectionbody">
</div>
</div>
<div class="sect1 use-gradle">
<h2 id="scratch">Build with Gradle</h2>
<div class="sectionbody">
<div class="paragraph">
<p>First you set up a basic build script. You can use any build system you like when building apps with Spring, but the code you need to work with <a href="http://gradle.org">Gradle</a> and <a href="https://maven.apache.org">Maven</a> is included here. If you’re not familiar with either, refer to <a href="/guides/gs/gradle">Building Java Projects with Gradle</a> or <a href="/guides/gs/maven">Building Java Projects with Maven</a>.</p>
</div>
<div class="sect2">
<h3 id="_create_the_directory_structure">Create the directory structure</h3>
<div class="paragraph">
<p>In a project directory of your choosing, create the following subdirectory structure; for example, with <code>mkdir -p src/main/java/hello</code> on *nix systems:</p>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">└── src
    └── main
        └── java
            └── hello</pre>
</div>
</div>
</div>
<div class="sect2">
<h3 id="_create_a_gradle_build_file">Create a Gradle build file</h3>
<div class="paragraph">
<p>Below is the <a href="https://github.com/spring-guides/gs-actuator-service/blob/master/initial/build.gradle">initial Gradle build file</a>.</p>
</div>
<div class="paragraph">
<p><code>build.gradle</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-2" data-clipboard-target="#code-block-2"></button><pre class="prettyprint highlight" id="code-block-2"><code class="language-java" data-lang="java"><span class="pln">buildscript </span><span class="pun">{</span><span class="pln">
    repositories </span><span class="pun">{</span><span class="pln">
        mavenCentral</span><span class="pun">()</span><span class="pln">
    </span><span class="pun">}</span><span class="pln">
    dependencies </span><span class="pun">{</span><span class="pln">
        classpath</span><span class="pun">(</span><span class="str">"org.springframework.boot:spring-boot-gradle-plugin:2.0.5.RELEASE"</span><span class="pun">)</span><span class="pln">
    </span><span class="pun">}</span><span class="pln">
</span><span class="pun">}</span><span class="pln">

apply plugin</span><span class="pun">:</span><span class="pln"> </span><span class="str">'java'</span><span class="pln">
apply plugin</span><span class="pun">:</span><span class="pln"> </span><span class="str">'eclipse'</span><span class="pln">
apply plugin</span><span class="pun">:</span><span class="pln"> </span><span class="str">'idea'</span><span class="pln">
apply plugin</span><span class="pun">:</span><span class="pln"> </span><span class="str">'org.springframework.boot'</span><span class="pln">
apply plugin</span><span class="pun">:</span><span class="pln"> </span><span class="str">'io.spring.dependency-management'</span><span class="pln">

bootJar </span><span class="pun">{</span><span class="pln">
    baseName </span><span class="pun">=</span><span class="pln"> </span><span class="str">'gs-actuator-service'</span><span class="pln">
    version </span><span class="pun">=</span><span class="pln">  </span><span class="str">'0.1.0'</span><span class="pln">
</span><span class="pun">}</span><span class="pln">

sourceCompatibility </span><span class="pun">=</span><span class="pln"> </span><span class="lit">1.8</span><span class="pln">
targetCompatibility </span><span class="pun">=</span><span class="pln"> </span><span class="lit">1.8</span><span class="pln">

repositories </span><span class="pun">{</span><span class="pln">
    mavenCentral</span><span class="pun">()</span><span class="pln">
</span><span class="pun">}</span><span class="pln">

dependencies </span><span class="pun">{</span><span class="pln">
    compile</span><span class="pun">(</span><span class="str">"org.springframework.boot:spring-boot-starter-web"</span><span class="pun">)</span><span class="pln">
    compile</span><span class="pun">(</span><span class="str">"org.springframework.boot:spring-boot-starter-actuator"</span><span class="pun">)</span><span class="pln">
    testCompile</span><span class="pun">(</span><span class="str">"org.springframework.boot:spring-boot-starter-test"</span><span class="pun">)</span><span class="pln">
    testCompile</span><span class="pun">(</span><span class="str">"junit:junit"</span><span class="pun">)</span><span class="pln">
</span><span class="pun">}</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>The <a href="https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html">Spring Boot gradle plugin</a> provides many convenient features:</p>
</div>
<div class="ulist">
<ul>
<li> <p>It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and transport your service.</p> </li>
<li> <p>It searches for the <code>public static void main()</code> method to flag as a runnable class.</p> </li>
<li> <p>It provides a built-in dependency resolver that sets the version number to match <a href="https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-dependencies/pom.xml">Spring Boot dependencies</a>. You can override any version you wish, but it will default to Boot’s chosen set of versions.</p> </li>
</ul>
</div>
</div>
</div>
</div>
<div class="sect1 reveal-maven">
<h2 id="reveal-maven">Build with Maven</h2>
<div class="sectionbody">
</div>
</div>
<div class="sect1 use-maven">
<h2 id="use-maven">Build with Maven</h2>
<div class="sectionbody">
<div class="paragraph">
<p>First you set up a basic build script. You can use any build system you like when building apps with Spring, but the code you need to work with <a href="https://maven.apache.org">Maven</a> is included here. If you’re not familiar with Maven, refer to <a href="/guides/gs/maven">Building Java Projects with Maven</a>.</p>
</div>
<div class="sect2">
<h3 id="_create_the_directory_structure_2">Create the directory structure</h3>
<div class="paragraph">
<p>In a project directory of your choosing, create the following subdirectory structure; for example, with <code>mkdir -p src/main/java/hello</code> on *nix systems:</p>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">└── src
    └── main
        └── java
            └── hello</pre>
</div>
</div>
<div class="paragraph">
<p><code>pom.xml</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-3" data-clipboard-target="#code-block-3"></button><pre class="prettyprint highlight" id="code-block-3"><code class="language-xml" data-lang="xml"><span class="pun">&lt;?</span><span class="pln">xml version</span><span class="pun">=</span><span class="str">"1.0"</span><span class="pln"> encoding</span><span class="pun">=</span><span class="str">"UTF-8"</span><span class="pun">?&gt;</span><span class="pln">
</span><span class="tag">&lt;project</span><span class="pln"> </span><span class="atn">xmlns</span><span class="pun">=</span><span class="atv">"http://maven.apache.org/POM/4.0.0"</span><span class="pln"> </span><span class="atn">xmlns:xsi</span><span class="pun">=</span><span class="atv">"http://www.w3.org/2001/XMLSchema-instance"</span><span class="pln">
    </span><span class="atn">xsi:schemaLocation</span><span class="pun">=</span><span class="atv">"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"</span><span class="tag">&gt;</span><span class="pln">
    </span><span class="tag">&lt;modelVersion&gt;</span><span class="pln">4.0.0</span><span class="tag">&lt;/modelVersion&gt;</span><span class="pln">

    </span><span class="tag">&lt;groupId&gt;</span><span class="pln">org.springframework</span><span class="tag">&lt;/groupId&gt;</span><span class="pln">
    </span><span class="tag">&lt;artifactId&gt;</span><span class="pln">gs-actuator-service</span><span class="tag">&lt;/artifactId&gt;</span><span class="pln">
    </span><span class="tag">&lt;version&gt;</span><span class="pln">0.1.0</span><span class="tag">&lt;/version&gt;</span><span class="pln">

    </span><span class="tag">&lt;parent&gt;</span><span class="pln">
        </span><span class="tag">&lt;groupId&gt;</span><span class="pln">org.springframework.boot</span><span class="tag">&lt;/groupId&gt;</span><span class="pln">
        </span><span class="tag">&lt;artifactId&gt;</span><span class="pln">spring-boot-starter-parent</span><span class="tag">&lt;/artifactId&gt;</span><span class="pln">
        </span><span class="tag">&lt;version&gt;</span><span class="pln">2.0.5.RELEASE</span><span class="tag">&lt;/version&gt;</span><span class="pln">
    </span><span class="tag">&lt;/parent&gt;</span><span class="pln">

    </span><span class="tag">&lt;dependencies&gt;</span><span class="pln">
        </span><span class="tag">&lt;dependency&gt;</span><span class="pln">
            </span><span class="tag">&lt;groupId&gt;</span><span class="pln">org.springframework.boot</span><span class="tag">&lt;/groupId&gt;</span><span class="pln">
            </span><span class="tag">&lt;artifactId&gt;</span><span class="pln">spring-boot-starter-web</span><span class="tag">&lt;/artifactId&gt;</span><span class="pln">
        </span><span class="tag">&lt;/dependency&gt;</span><span class="pln">
        </span><span class="tag">&lt;dependency&gt;</span><span class="pln">
            </span><span class="tag">&lt;groupId&gt;</span><span class="pln">org.springframework.boot</span><span class="tag">&lt;/groupId&gt;</span><span class="pln">
            </span><span class="tag">&lt;artifactId&gt;</span><span class="pln">spring-boot-starter-actuator</span><span class="tag">&lt;/artifactId&gt;</span><span class="pln">
        </span><span class="tag">&lt;/dependency&gt;</span><span class="pln">
        </span><span class="tag">&lt;dependency&gt;</span><span class="pln">
            </span><span class="tag">&lt;groupId&gt;</span><span class="pln">org.springframework.boot</span><span class="tag">&lt;/groupId&gt;</span><span class="pln">
            </span><span class="tag">&lt;artifactId&gt;</span><span class="pln">spring-boot-starter-test</span><span class="tag">&lt;/artifactId&gt;</span><span class="pln">
            </span><span class="tag">&lt;scope&gt;</span><span class="pln">test</span><span class="tag">&lt;/scope&gt;</span><span class="pln">
        </span><span class="tag">&lt;/dependency&gt;</span><span class="pln">
    </span><span class="tag">&lt;/dependencies&gt;</span><span class="pln">

    </span><span class="tag">&lt;properties&gt;</span><span class="pln">
        </span><span class="tag">&lt;java.version&gt;</span><span class="pln">1.8</span><span class="tag">&lt;/java.version&gt;</span><span class="pln">
    </span><span class="tag">&lt;/properties&gt;</span><span class="pln">

    </span><span class="tag">&lt;build&gt;</span><span class="pln">
        </span><span class="tag">&lt;plugins&gt;</span><span class="pln">
            </span><span class="tag">&lt;plugin&gt;</span><span class="pln">
                </span><span class="tag">&lt;groupId&gt;</span><span class="pln">org.springframework.boot</span><span class="tag">&lt;/groupId&gt;</span><span class="pln">
                </span><span class="tag">&lt;artifactId&gt;</span><span class="pln">spring-boot-maven-plugin</span><span class="tag">&lt;/artifactId&gt;</span><span class="pln">
            </span><span class="tag">&lt;/plugin&gt;</span><span class="pln">
        </span><span class="tag">&lt;/plugins&gt;</span><span class="pln">
    </span><span class="tag">&lt;/build&gt;</span><span class="pln">

</span><span class="tag">&lt;/project&gt;</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>The <a href="https://docs.spring.io/spring-boot/docs/current/maven-plugin">Spring Boot Maven plugin</a> provides many convenient features:</p>
</div>
<div class="ulist">
<ul>
<li> <p>It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and transport your service.</p> </li>
<li> <p>It searches for the <code>public static void main()</code> method to flag as a runnable class.</p> </li>
<li> <p>It provides a built-in dependency resolver that sets the version number to match <a href="https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-dependencies/pom.xml">Spring Boot dependencies</a>. You can override any version you wish, but it will default to Boot’s chosen set of versions.</p> </li>
</ul>
</div>
</div>
</div>
</div>
<div class="sect1 reveal-sts">
<h2 id="reveal-sts">Build with your IDE</h2>
<div class="sectionbody">
</div>
</div>
<div class="sect1 use-sts">
<h2 id="use-sts">Build with your IDE</h2>
<div class="sectionbody">
<div class="ulist">
<ul>
<li> <p>Read how to import this guide straight into <a href="/guides/gs/sts/">Spring Tool Suite</a>.</p> </li>
<li> <p>Read how to work with this guide in <a href="/guides/gs/intellij-idea">IntelliJ IDEA</a>.</p> </li>
</ul>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_run_the_empty_service">Run the empty service</h2>
<div class="sectionbody">
<div class="paragraph">
<p>For starters, here’s an empty Spring MVC application.</p>
</div>
<div class="paragraph">
<p><code>src/main/java/hello/HelloWorldApplication.java</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-4" data-clipboard-target="#code-block-4"></button><pre class="prettyprint highlight" id="code-block-4"><code class="language-java" data-lang="java"><span class="kwd">package</span><span class="pln"> hello</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">boot</span><span class="pun">.</span><span class="typ">SpringApplication</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">boot</span><span class="pun">.</span><span class="pln">autoconfigure</span><span class="pun">.</span><span class="typ">SpringBootApplication</span><span class="pun">;</span><span class="pln">

</span><span class="lit">@SpringBootApplication</span><span class="pln">
</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">HelloWorldApplication</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

    </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> main</span><span class="pun">(</span><span class="typ">String</span><span class="pun">[]</span><span class="pln"> args</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
        </span><span class="typ">SpringApplication</span><span class="pun">.</span><span class="pln">run</span><span class="pun">(</span><span class="typ">HelloWorldApplication</span><span class="pun">.</span><span class="kwd">class</span><span class="pun">,</span><span class="pln"> args</span><span class="pun">);</span><span class="pln">
    </span><span class="pun">}</span><span class="pln">

</span><span class="pun">}</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>The <code>@SpringBootApplication</code> annotation provides a load of defaults (like the embedded servlet container) depending on the contents of your classpath, and other things. It also turns on Spring MVC’s @EnableWebMvc annotation that activates web endpoints.</p>
</div>
<div class="paragraph">
<p>There aren’t any endpoints defined in this application, but there’s enough to launch things and see some of Actuator’s features. The <code>SpringApplication.run()</code> command knows how to launch the web application. All you need to do is run this command.</p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-5" data-clipboard-target="#code-block-5"></button><pre id="code-block-5" class="prettyprint">$ ./gradlew clean build &amp;&amp; java -jar build/libs/gs-actuator-service-0.1.0.jar</pre>
</div>
</div>
<div class="paragraph">
<p>You hardly written any code yet, so what’s happening? Wait for the server to start and go to another terminal to try it out:</p>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">$ curl localhost:8080
{"timestamp":1384788106983,"error":"Not Found","status":404,"message":""}</pre>
</div>
</div>
<div class="paragraph">
<p>So the server is running, but you haven’t defined any business endpoints yet. Instead of a default container-generated HTML error response, you see a generic JSON response from the Actuator <code>/error</code> endpoint. You can see in the console logs from the server startup which endpoints are provided out of the box. Try a few out, for example</p>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">$ curl localhost:8080/actuator/health
{"status":"UP"}</pre>
</div>
</div>
<div class="paragraph">
<p>You’re "UP", so that’s good.</p>
</div>
<div class="paragraph">
<p>Check out Spring Boot’s <a href="https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-actuator">Actuator Project</a> for more details.</p>
</div>
</div>
</div>
<div class="sect1">
<h2 id="initial">Create a representation class</h2>
<div class="sectionbody">
<div class="paragraph">
<p>First, give some thought to what your API will look like.</p>
</div>
<div class="paragraph">
<p>You want to handle GET requests for <code>/hello-world</code>, optionally with a name query parameter. In response to such a request, you will send back JSON, representing a greeting, that looks something like this:</p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-6" data-clipboard-target="#code-block-6"></button><pre class="prettyprint highlight" id="code-block-6"><code class="language-json" data-lang="json"><span class="pun">{</span><span class="pln">
    </span><span class="str">"id"</span><span class="pun">:</span><span class="pln"> </span><span class="lit">1</span><span class="pun">,</span><span class="pln">
    </span><span class="str">"content"</span><span class="pun">:</span><span class="pln"> </span><span class="str">"Hello, World!"</span><span class="pln">
</span><span class="pun">}</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>The <code>id</code> field is a unique identifier for the greeting, and <code>content</code> is the textual representation of the greeting.</p>
</div>
<div class="paragraph">
<p>To model the greeting representation, create a representation class:</p>
</div>
<div class="paragraph">
<p><code>src/main/java/hello/Greeting.java</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-7" data-clipboard-target="#code-block-7"></button><pre class="prettyprint highlight" id="code-block-7"><code class="language-java" data-lang="java"><span class="kwd">package</span><span class="pln"> hello</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">Greeting</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

    </span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">final</span><span class="pln"> </span><span class="kwd">long</span><span class="pln"> id</span><span class="pun">;</span><span class="pln">
    </span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">final</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> content</span><span class="pun">;</span><span class="pln">

    </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Greeting</span><span class="pun">(</span><span class="kwd">long</span><span class="pln"> id</span><span class="pun">,</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> content</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
        </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">id </span><span class="pun">=</span><span class="pln"> id</span><span class="pun">;</span><span class="pln">
        </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">content </span><span class="pun">=</span><span class="pln"> content</span><span class="pun">;</span><span class="pln">
    </span><span class="pun">}</span><span class="pln">

    </span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">long</span><span class="pln"> getId</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
        </span><span class="kwd">return</span><span class="pln"> id</span><span class="pun">;</span><span class="pln">
    </span><span class="pun">}</span><span class="pln">

    </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> getContent</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
        </span><span class="kwd">return</span><span class="pln"> content</span><span class="pun">;</span><span class="pln">
    </span><span class="pun">}</span><span class="pln">

</span><span class="pun">}</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>Now that you’ll create the endpoint controller that will serve the representation class.</p>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_create_a_resource_controller">Create a resource controller</h2>
<div class="sectionbody">
<div class="paragraph">
<p>In Spring, REST endpoints are just Spring MVC controllers. The following Spring MVC controller handles a GET request for /hello-world and returns the <code>Greeting</code> resource:</p>
</div>
<div class="paragraph">
<p><code>src/main/java/hello/HelloWorldController.java</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-8" data-clipboard-target="#code-block-8"></button><pre class="prettyprint highlight" id="code-block-8"><code class="language-java" data-lang="java"><span class="kwd">package</span><span class="pln"> hello</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="pln">concurrent</span><span class="pun">.</span><span class="pln">atomic</span><span class="pun">.</span><span class="typ">AtomicLong</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">stereotype</span><span class="pun">.</span><span class="typ">Controller</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">web</span><span class="pun">.</span><span class="pln">bind</span><span class="pun">.</span><span class="pln">annotation</span><span class="pun">.</span><span class="typ">GetMapping</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">web</span><span class="pun">.</span><span class="pln">bind</span><span class="pun">.</span><span class="pln">annotation</span><span class="pun">.</span><span class="typ">RequestParam</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">web</span><span class="pun">.</span><span class="pln">bind</span><span class="pun">.</span><span class="pln">annotation</span><span class="pun">.</span><span class="typ">ResponseBody</span><span class="pun">;</span><span class="pln">

</span><span class="lit">@Controller</span><span class="pln">
</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">HelloWorldController</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

    </span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">final</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> </span><span class="kwd">template</span><span class="pln"> </span><span class="pun">=</span><span class="pln"> </span><span class="str">"Hello, %s!"</span><span class="pun">;</span><span class="pln">
    </span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">final</span><span class="pln"> </span><span class="typ">AtomicLong</span><span class="pln"> counter </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">AtomicLong</span><span class="pun">();</span><span class="pln">

    </span><span class="lit">@GetMapping</span><span class="pun">(</span><span class="str">"/hello-world"</span><span class="pun">)</span><span class="pln">
    </span><span class="lit">@ResponseBody</span><span class="pln">
    </span><span class="kwd">public</span><span class="pln"> </span><span class="typ">Greeting</span><span class="pln"> sayHello</span><span class="pun">(</span><span class="lit">@RequestParam</span><span class="pun">(</span><span class="pln">name</span><span class="pun">=</span><span class="str">"name"</span><span class="pun">,</span><span class="pln"> required</span><span class="pun">=</span><span class="kwd">false</span><span class="pun">,</span><span class="pln"> defaultValue</span><span class="pun">=</span><span class="str">"Stranger"</span><span class="pun">)</span><span class="pln"> </span><span class="typ">String</span><span class="pln"> name</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
        </span><span class="kwd">return</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">Greeting</span><span class="pun">(</span><span class="pln">counter</span><span class="pun">.</span><span class="pln">incrementAndGet</span><span class="pun">(),</span><span class="pln"> </span><span class="typ">String</span><span class="pun">.</span><span class="pln">format</span><span class="pun">(</span><span class="kwd">template</span><span class="pun">,</span><span class="pln"> name</span><span class="pun">));</span><span class="pln">
    </span><span class="pun">}</span><span class="pln">

</span><span class="pun">}</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>The key difference between a human-facing controller and a REST endpoint controller is in how the response is created. Rather than rely on a view (such as JSP) to render model data in HTML, an endpoint controller simply returns the data to be written directly to the body of the response.</p>
</div>
<div class="paragraph">
<p>The <a href="https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseBody.html"><code>@ResponseBody</code></a> annotation tells Spring MVC not to render a model into a view, but rather to write the returned object into the response body. It does this by using one of Spring’s message converters. Because Jackson 2 is in the classpath, this means that <a href="https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/json/MappingJackson2HttpMessageConverter.html"><code>MappingJackson2HttpMessageConverter</code></a> will handle the conversion of Greeting to JSON if the request’s <code>Accept</code> header specifies that JSON should be returned.</p>
</div>
<div class="admonitionblock note">
<table>
<tbody>
<tr>
<td class="icon"> <i class="fa icon-note" title="Note"></i> </td>
<td class="content"> How do you know Jackson 2 is on the classpath? Either run ` mvn dependency:tree` or <code>./gradlew dependencies</code> and you’ll get a detailed tree of dependencies which shows Jackson 2.x. You can also see that it comes from <a href="https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters/spring-boot-starter-json">/spring-boot-starter-json</a>, itself imported by <a href="https://github.com/spring-projects/spring-boot/blob/master/spring-boot-starters/spring-boot-starter-web/pom.xml">spring-boot-starter-web</a>. </td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_create_an_executable_main_class">Create an executable main class</h2>
<div class="sectionbody">
<div class="paragraph">
<p>You can launch the application from a custom main class, or we can do that directly from one of the configuration classes. The easiest way is to use the <code>SpringApplication</code> helper class:</p>
</div>
<div class="paragraph">
<p><code>src/main/java/hello/HelloWorldApplication.java</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-9" data-clipboard-target="#code-block-9"></button><pre class="prettyprint highlight" id="code-block-9"><code class="language-java" data-lang="java"><span class="kwd">package</span><span class="pln"> hello</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">boot</span><span class="pun">.</span><span class="typ">SpringApplication</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">boot</span><span class="pun">.</span><span class="pln">autoconfigure</span><span class="pun">.</span><span class="typ">SpringBootApplication</span><span class="pun">;</span><span class="pln">

</span><span class="lit">@SpringBootApplication</span><span class="pln">
</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">HelloWorldApplication</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

	</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> main</span><span class="pun">(</span><span class="typ">String</span><span class="pun">[]</span><span class="pln"> args</span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
		</span><span class="typ">SpringApplication</span><span class="pun">.</span><span class="pln">run</span><span class="pun">(</span><span class="typ">HelloWorldApplication</span><span class="pun">.</span><span class="kwd">class</span><span class="pun">,</span><span class="pln"> args</span><span class="pun">);</span><span class="pln">
	</span><span class="pun">}</span><span class="pln">

</span><span class="pun">}</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>In a conventional Spring MVC application, you would add <code>@EnableWebMvc</code> to turn on key behaviors including configuration of a <code>DispatcherServlet</code>. But Spring Boot turns on this annotation automatically when it detects <strong>spring-webmvc</strong> on your classpath. This sets you up to build a controller in an upcoming step.</p>
</div>
<div class="paragraph">
<p>The <code>@SpringBootApplication</code> also brings in a <a href="https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html"><code>@ComponentScan</code></a>, which tells Spring to scan the <code>hello</code> package for those controllers (along with any other annotated component classes).</p>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_build_an_executable_jar">Build an executable JAR</h2>
<div class="sectionbody">
<div class="paragraph">
<p>You can run the application from the command line with Gradle or Maven. Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources, and run that. This makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.</p>
</div>
<div class="paragraph">
<p>If you are using Gradle, you can run the application using <code>./gradlew bootRun</code>. Or you can build the JAR file using <code>./gradlew build</code>. Then you can run the JAR file:</p>
</div>
<div class="literalblock has-copy-button">
<div class="content">
<button class="copy-button snippet" id="copy-button-10" data-clipboard-target="#code-block-10"></button><pre id="code-block-10" class="prettyprint">java -jar build/libs/gs-actuator-service-0.1.0.jar</pre>
</div>
</div>
<div class="paragraph">
<p>If you are using Maven, you can run the application using <code>./mvnw spring-boot:run</code>. Or you can build the JAR file with <code>./mvnw clean package</code>. Then you can run the JAR file:</p>
</div>
<div class="literalblock has-copy-button">
<div class="content">
<button class="copy-button snippet" id="copy-button-11" data-clipboard-target="#code-block-11"></button><pre id="code-block-11" class="prettyprint">java -jar target/gs-actuator-service-0.1.0.jar</pre>
</div>
</div>
<div class="admonitionblock note">
<table>
<tbody>
<tr>
<td class="icon"> <i class="fa icon-note" title="Note"></i> </td>
<td class="content"> The procedure above will create a runnable JAR. You can also opt to <a href="/guides/gs/convert-jar-to-war/">build a classic WAR file</a> instead. </td>
</tr>
</tbody>
</table>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">... service comes up ...</pre>
</div>
</div>
<div class="paragraph">
<p>Test it:</p>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">$ curl localhost:8080/hello-world
{"id":1,"content":"Hello, Stranger!"}</pre>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_switch_to_a_different_server_port">Switch to a different server port</h2>
<div class="sectionbody">
<div class="paragraph">
<p>Spring Boot Actuator defaults to run on port 8080. By adding an <code>application.properties</code> file, you can override that setting.</p>
</div>
<div class="paragraph">
<p><code>src/main/resources/application.properties</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-12" data-clipboard-target="#code-block-12"></button><pre class="prettyprint highlight" id="code-block-12"><code class="language-properties" data-lang="properties"><span class="pln">server</span><span class="pun">.</span><span class="pln">port</span><span class="pun">:</span><span class="pln"> </span><span class="lit">9000</span><span class="pln">
management</span><span class="pun">.</span><span class="pln">server</span><span class="pun">.</span><span class="pln">port</span><span class="pun">:</span><span class="pln"> </span><span class="lit">9001</span><span class="pln">
management</span><span class="pun">.</span><span class="pln">server</span><span class="pun">.</span><span class="pln">address</span><span class="pun">:</span><span class="pln"> </span><span class="lit">127.0</span><span class="pun">.</span><span class="lit">0.1</span></code></pre>
</div>
</div>
<div class="paragraph">
<p>Run the server again:</p>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">$ ./gradlew clean build &amp;&amp; java -jar build/libs/gs-actuator-service-0.1.0.jar

... service comes up on port 9000 ...</pre>
</div>
</div>
<div class="paragraph">
<p>Test it:</p>
</div>
<div class="literalblock">
<div class="content">
<pre class="prettyprint">$ curl localhost:8080/hello-world
curl: (52) Empty reply from server
$ curl localhost:9000/hello-world
{"id":1,"content":"Hello, Stranger!"}
$ curl localhost:9001/actuator/health
{"status":"UP"}</pre>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_test_your_application">Test your application</h2>
<div class="sectionbody">
<div class="paragraph">
<p>In order to check if your application is functional you should write unit / integration tests of your application. Below you can find an example of such a test that checks:</p>
</div>
<div class="ulist">
<ul>
<li> <p>if your controller is responsive</p> </li>
<li> <p>if your management endpoint is responsive</p> </li>
</ul>
</div>
<div class="paragraph">
<p>As you can see for tests we’re starting the application on a random port.</p>
</div>
<div class="paragraph">
<p><code>src/test/java/hello/HelloWorldApplicationTests.java</code></p>
</div>
<div class="listingblock">
<div class="content">
<button class="copy-button snippet" id="copy-button-13" data-clipboard-target="#code-block-13"></button><pre class="prettyprint highlight" id="code-block-13"><code class="language-java" data-lang="java"><span class="com">/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */</span><span class="pln">
</span><span class="kwd">package</span><span class="pln"> hello</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">Map</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">junit</span><span class="pun">.</span><span class="typ">Test</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">junit</span><span class="pun">.</span><span class="pln">runner</span><span class="pun">.</span><span class="typ">RunWith</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">beans</span><span class="pun">.</span><span class="pln">factory</span><span class="pun">.</span><span class="pln">annotation</span><span class="pun">.</span><span class="typ">Autowired</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">beans</span><span class="pun">.</span><span class="pln">factory</span><span class="pun">.</span><span class="pln">annotation</span><span class="pun">.</span><span class="typ">Value</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">boot</span><span class="pun">.</span><span class="pln">test</span><span class="pun">.</span><span class="pln">context</span><span class="pun">.</span><span class="typ">SpringBootTest</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">boot</span><span class="pun">.</span><span class="pln">test</span><span class="pun">.</span><span class="pln">web</span><span class="pun">.</span><span class="pln">client</span><span class="pun">.</span><span class="typ">TestRestTemplate</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">boot</span><span class="pun">.</span><span class="pln">web</span><span class="pun">.</span><span class="pln">server</span><span class="pun">.</span><span class="typ">LocalServerPort</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">http</span><span class="pun">.</span><span class="typ">HttpStatus</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">http</span><span class="pun">.</span><span class="typ">ResponseEntity</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">test</span><span class="pun">.</span><span class="pln">context</span><span class="pun">.</span><span class="typ">TestPropertySource</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">springframework</span><span class="pun">.</span><span class="pln">test</span><span class="pun">.</span><span class="pln">context</span><span class="pun">.</span><span class="pln">junit4</span><span class="pun">.</span><span class="typ">SpringRunner</span><span class="pun">;</span><span class="pln">

</span><span class="kwd">import</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> org</span><span class="pun">.</span><span class="pln">assertj</span><span class="pun">.</span><span class="pln">core</span><span class="pun">.</span><span class="pln">api</span><span class="pun">.</span><span class="typ">BDDAssertions</span><span class="pun">.</span><span class="kwd">then</span><span class="pun">;</span><span class="pln">

</span><span class="com">/**
 * Basic integration tests for service demo application.
 *
 * @author Dave Syer
 */</span><span class="pln">
</span><span class="lit">@RunWith</span><span class="pun">(</span><span class="typ">SpringRunner</span><span class="pun">.</span><span class="kwd">class</span><span class="pun">)</span><span class="pln">
</span><span class="lit">@SpringBootTest</span><span class="pun">(</span><span class="pln">webEnvironment </span><span class="pun">=</span><span class="pln"> </span><span class="typ">SpringBootTest</span><span class="pun">.</span><span class="typ">WebEnvironment</span><span class="pun">.</span><span class="pln">RANDOM_PORT</span><span class="pun">)</span><span class="pln">
</span><span class="lit">@TestPropertySource</span><span class="pun">(</span><span class="pln">properties </span><span class="pun">=</span><span class="pln"> </span><span class="pun">{</span><span class="str">"management.port=0"</span><span class="pun">})</span><span class="pln">
</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">class</span><span class="pln"> </span><span class="typ">HelloWorldApplicationTests</span><span class="pln"> </span><span class="pun">{</span><span class="pln">

	</span><span class="lit">@LocalServerPort</span><span class="pln">
	</span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">int</span><span class="pln"> port</span><span class="pun">;</span><span class="pln">

	</span><span class="lit">@Value</span><span class="pun">(</span><span class="str">"${local.management.port}"</span><span class="pun">)</span><span class="pln">
	</span><span class="kwd">private</span><span class="pln"> </span><span class="kwd">int</span><span class="pln"> mgt</span><span class="pun">;</span><span class="pln">

	</span><span class="lit">@Autowired</span><span class="pln">
	</span><span class="kwd">private</span><span class="pln"> </span><span class="typ">TestRestTemplate</span><span class="pln"> testRestTemplate</span><span class="pun">;</span><span class="pln">

	</span><span class="lit">@Test</span><span class="pln">
	</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> shouldReturn200WhenSendingRequestToController</span><span class="pun">()</span><span class="pln"> </span><span class="kwd">throws</span><span class="pln"> </span><span class="typ">Exception</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
		</span><span class="lit">@SuppressWarnings</span><span class="pun">(</span><span class="str">"rawtypes"</span><span class="pun">)</span><span class="pln">
		</span><span class="typ">ResponseEntity</span><span class="pun">&lt;</span><span class="typ">Map</span><span class="pun">&gt;</span><span class="pln"> entity </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">testRestTemplate</span><span class="pun">.</span><span class="pln">getForEntity</span><span class="pun">(</span><span class="pln">
				</span><span class="str">"http://localhost:"</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">port </span><span class="pun">+</span><span class="pln"> </span><span class="str">"/hello-world"</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Map</span><span class="pun">.</span><span class="kwd">class</span><span class="pun">);</span><span class="pln">

		</span><span class="kwd">then</span><span class="pun">(</span><span class="pln">entity</span><span class="pun">.</span><span class="pln">getStatusCode</span><span class="pun">()).</span><span class="pln">isEqualTo</span><span class="pun">(</span><span class="typ">HttpStatus</span><span class="pun">.</span><span class="pln">OK</span><span class="pun">);</span><span class="pln">
	</span><span class="pun">}</span><span class="pln">

	</span><span class="lit">@Test</span><span class="pln">
	</span><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> shouldReturn200WhenSendingRequestToManagementEndpoint</span><span class="pun">()</span><span class="pln"> </span><span class="kwd">throws</span><span class="pln"> </span><span class="typ">Exception</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
		</span><span class="lit">@SuppressWarnings</span><span class="pun">(</span><span class="str">"rawtypes"</span><span class="pun">)</span><span class="pln">
		</span><span class="typ">ResponseEntity</span><span class="pun">&lt;</span><span class="typ">Map</span><span class="pun">&gt;</span><span class="pln"> entity </span><span class="pun">=</span><span class="pln"> </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">testRestTemplate</span><span class="pun">.</span><span class="pln">getForEntity</span><span class="pun">(</span><span class="pln">
				</span><span class="str">"http://localhost:"</span><span class="pln"> </span><span class="pun">+</span><span class="pln"> </span><span class="kwd">this</span><span class="pun">.</span><span class="pln">mgt </span><span class="pun">+</span><span class="pln"> </span><span class="str">"/actuator/info"</span><span class="pun">,</span><span class="pln"> </span><span class="typ">Map</span><span class="pun">.</span><span class="kwd">class</span><span class="pun">);</span><span class="pln">

		</span><span class="kwd">then</span><span class="pun">(</span><span class="pln">entity</span><span class="pun">.</span><span class="pln">getStatusCode</span><span class="pun">()).</span><span class="pln">isEqualTo</span><span class="pun">(</span><span class="typ">HttpStatus</span><span class="pun">.</span><span class="pln">OK</span><span class="pun">);</span><span class="pln">
	</span><span class="pun">}</span><span class="pln">

</span><span class="pun">}</span></code></pre>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_summary">Summary</h2>
<div class="sectionbody">
<div class="paragraph">
<p>Congratulations! You have just developed a simple RESTful service using Spring. You added some useful built-in services thanks to Spring Boot Actuator.</p>
</div>
</div>
</div>
<div class="sect1">
<h2 id="_see_also">See Also</h2>
<div class="sectionbody">
<div class="paragraph">
<p>The following guides may also be helpful:</p>
</div>
<div class="ulist">
<ul>
<li> <p><a href="https://spring.io/guides/gs/spring-boot/">Building an Application with Spring Boot</a></p> </li>
<li> <p><a href="https://spring.io/guides/gs/serving-web-content/">Serving Web Content with Spring MVC</a></p> </li>
</ul>
</div>
<div class="paragraph">
<p>Want to write a new guide or contribute to an existing one? Check out our <a href="https://github.com/spring-guides/getting-started-guides/wiki">contribution guidelines</a>.</p>
</div>
<div class="admonitionblock important">
<table>
<tbody>
<tr>
<td class="icon"> <i class="fa icon-important" title="Important"></i> </td>
<td class="content"> All guides are released with an ASLv2 license for the code, and an <a href="https://creativecommons.org/licenses/by-nd/3.0/">Attribution, NoDerivatives creative commons license</a> for the writing. </td>
</tr>
</tbody>
</table>
</div>
</div>
</div></div>
</article>
</div>
<aside class="span4 content-right-pane--container mobile-left-pane" id="sidebar">
<a class="ci-status desktop-only" href="https://travis-ci.org/spring-guides/gs-actuator-service">
<img src="https://travis-ci.org/spring-guides/gs-actuator-service.svg?branch=master">
</a>
<div class="right-pane-widget--container desktop-only">
<div class="github-actions https">
<h2>Get the Code</h2>
<div class="btn-group">
<button class="btn" data-protocol="https">HTTPS</button>
<button class="btn" data-protocol="ssh">SSH</button>
<button class="btn" data-protocol="subversion">Subversion</button>
</div>
<div class="clone-url https">
<input id="clone-url-https" readonly="readonly" type="text" value="https://github.com/spring-guides/gs-actuator-service.git">
<button class="copy-button github" data-toggle="tooltip" data-clipboard-text="https://github.com/spring-guides/gs-actuator-service.git"></button>
</div>
<div class="clone-url ssh">
<input id="clone-url-ssh" readonly="readonly" type="text" value="git@github.com:spring-guides/gs-actuator-service.git">
<button class="copy-button github" data-toggle="tooltip" data-clipboard-text="git@github.com:spring-guides/gs-actuator-service.git"></button>
</div>
<div class="clone-url subversion">
<input id="clone-url-subversion" readonly="readonly" type="text" value="https://github.com/spring-guides/gs-actuator-service">
<button class="copy-button github" data-toggle="tooltip" data-clipboard-text="https://github.com/spring-guides/gs-actuator-service"></button>
</div>
<a class="github_download btn btn-black uppercase" href="https://github.com/spring-guides/gs-actuator-service/archive/master.zip">Download ZIP</a>
<a class="gs-guide-import" href="https://github.com/spring-guides/gs-actuator-service">Import into STS</a>
<div class="go-to-repo--container">
<a href="https://github.com/spring-guides/gs-actuator-service">
<i class="icon-github"></i>
Go To Repo
</a>
</div>
</div>
</div>
<div class="right-pane-widget--container">
<div>
<h3><a class="anchor" href="#table-of-contents" name="table-of-contents"></a>Table of contents</h3>
<div><ul class="sectlevel1">
<li><a href="#_what_you_ll_build">What you’ll build</a> </li>
<li><a href="#_how_to_complete_this_guide">How to complete this guide</a></li>
<li><a href="#scratch">Build with Gradle</a> </li>
<li><a href="#use-maven">Build with Maven</a> </li>
<li><a href="#use-sts">Build with your IDE</a></li>
<li><a href="#_run_the_empty_service">Run the empty service</a></li>
<li><a href="#initial">Create a representation class</a></li>
<li><a href="#_create_a_resource_controller">Create a resource controller</a></li>
<li><a href="#_create_an_executable_main_class">Create an executable main class</a></li>
<li><a href="#_build_an_executable_jar">Build an executable JAR</a></li>
<li><a href="#_switch_to_a_different_server_port">Switch to a different server port</a></li>
<li><a href="#_test_your_application">Test your application</a></li>
<li><a href="#_summary">Summary</a></li>
<li><a href="#_see_also">See Also</a></li>
</ul></div>
</div>
</div>
</aside>
</div>
</main>