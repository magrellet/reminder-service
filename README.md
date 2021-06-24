1 - Mongo install in mac
  a - xcode-select --install
  b - brew tap mongodb/brew
  c - brew install mongodb-community@4.2
  d - echo 'export PATH="/usr/local/opt/mongodb-community@4.2/bin:$PATH"' >> ~/.profile
  e - brew services start mongodb/brew/mongodb-community@4.2
  f - Or, if you don't want/need a background service you can just run:
        mongod --config /usr/local/etc/mongod.conf
  g - Location /usr/local/Cellar/mongodb-community@4.2/4.2.12
  h - brew services start mongodb-community@4.2
  i - brew services stop mongodb-community@4.2
2 - Download compass:
  a - https://www.mongodb.com/try/download/compass