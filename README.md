# Scraperapi-java-sdk

# Build
You need to have maven and the java sdk installed.

### Compile
```
mvn compile
```

### Test
I wasn't able to make a test app use the compiled jar so I copied the source files next to the files of a test app

Example test app:
```
package com.example;

import com.scraperapi.ScraperApiClient;

public class Main {

    public static void main(String[] args) {
      ScraperApiClient client = new ScraperApiClient("3efecbbfcba00c3c399b10404ff7c3ce");
      for (int i = 0; i < 30; i++) {
        String url = "https://scraperapiloadtest.xyz/" + i;
        System.out.println(url);
        String result = client.get(url)
          .result();

        System.out.println(result);
      }
    }
}
```

### Publish

#### Maven reporsiory credentials
You need to have maven repository credentials on your host.
On linux it's the `/etc/maven/settings.xml` file.


The content should be:
```xml
<server>
  <id>${server}</id>
  <username>NRr2HapP</username>
  <password>iYn2d8bQysB7/F2FBqzeTxWLBjIplPgAFYNn19rlVV3v</password>
</server>
```

The maven central credentials are here: https://saasgroup.1password.com/app#/tbfugtawsizo6ozytggu5gv6nu/Search/tbfugtawsizo6ozytggu5gv6nunqosm3khwkexyagwdawj5ff7dq?itemListId=maven

Also here:
username:
```
engineering_scraperapi.com
```

password:
```
3kazcAK'6p*}~wZ
```

#### Signing keys
Download and import the keys from here: https://saasgroup.1password.com/app#/tbfugtawsizo6ozytggu5gv6nu/AllItems/tbfugtawsizo6ozytggu5gv6nuj5qcml2rlyn3nvuqxugjdtxesu




In case you need a new pgp key pair because let's say the old one is expired use this guide: https://keyring.debian.org/creating-key.html


Note the publish step at the end of description. You shoud also update the pgp key pair in one password and the key ID in  the pom.xml

#### Publishing

Run:
```
mvn deploy
```  

Good luck and a lot of patience!