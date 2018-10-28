#!/bin/bash

echo "calisiyor 0-0-"

stty -echo
echo "Mysql sifreniz(yazarken gozukmez)"
read password
stty echo

mysql -u root -p$password -Bse "CREATE DATABASE dbAracAlisSatis DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci"

mysql -u root -p$password dbAracAlisSatis < data.sql

mysql -u root -p$password -Bse "GRANT ALL PRIVILEGES ON dbAracAlisSatis.* To 'dbAASKullanici'@'localhost' IDENTIFIED BY 'dbAASKullaniciSifre'"

echo "sorun yok gibi -0-0"
