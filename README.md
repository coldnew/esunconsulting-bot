# esunconsulting-bot

[![Open Source Love](https://badges.frapsoft.com/os/v3/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/)
[![AGPL License](http://img.shields.io/badge/license-AGPL%20v3-red.svg?style=flat)](http://opensource.org/licenses/AGPL-3.0)

A telegram bot to fetch report from [玉山投顧](https://www.esunconsulting.com.tw/all_reports.asp) then send to specific telegram group.

## Usage (lein)

Modify `resources/config.edn`, replace following with your telegram's info:

``` clojure
{
 :esunconsulting/token     "YOUR-TELEGRAM-BOT-TOKEN"
 :esunconsulting/chat-id   "YOUR-TELEGRAM-GROUP-CHAT-ID"
}
```

The first time to run this bot, you need to generate/migrate the database:

``` shell
lein run -- migrate
```

the, just run

``` shell
lein run
```

## Screenshots

This is the screenshot what this bot does, I use it on my own telegram group.

![Screenshot](https://github.com/coldnew/esunconsulting-bot/raw/master/screenshot.jpg)

## License

Copyright © 2018 Yen-Chin, Lee <coldnew.tw@gmail.com>

Distributed under the [GNU Affero General Public License 3.0 (AGPL-3.0)](https://www.gnu.org/licenses/agpl-3.0.en.html).
