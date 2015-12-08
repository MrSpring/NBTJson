``build.gradle``
```
repositories: {
    maven {
        name "mrspring"
        url "http://mrspring.dk/maven/"
    }    
}

dependencies {
    releaseJars "dk.mrspring:NBTJson:1.0.0-1.7.10:deobf"
}

configurations {
    releaseJars
}

jar {
    from configurations.releaseJars.collect {
        it.isDirectory() ? it : zipTree(it)
    }
}
```