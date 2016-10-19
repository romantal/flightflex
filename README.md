# DataFlex

The goal of this application is made possible to get data from remote source about frights.
In this example data loading is implemented from http://www.edreams.com web site. It loads Flight places (cities) by suggestion.

It is a prototype for application which implements only one use case - loading dictionary of flight places.
Application shows how to use design patterns like Factory, Builder, Repository, Singleton.
Also it shows how to use Java Exceptions in practice.

To download and parce data from remote web site application uses PhantomJS headless browser.
The reason of usage of headless browser "PhantomJS" is using AJAX with Java Script stuff by remote web site.
In other case makes sense to use only Java native classes like HTTPConnection.

## Installation

Steps to install application:

1) download phantomjs software (http://phantomjs.org/download.html)
2) unpack archive into new crteated folder, for example: D:\usr\local\phantomjs-2.1.1-windows
3) build project with maven

## Usage

Run cmd file run.cmd and see result in console.

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## History

TODO: Write history

## Credits

TODO: Write credits

## License

TODO: Write license



