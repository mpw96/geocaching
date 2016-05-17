#!/bin/bash

rm -f Acme-Chef-1.01.tar.gz
rm -rf Acme-Chef-1.01
rm -rf modules

wget http://search.cpan.org/CPAN/authors/id/S/SM/SMUELLER/Acme-Chef-1.01.tar.gz
tar -xvzf Acme-Chef-1.01.tar.gz
mkdir modules

pushd Acme-Chef-1.01
perl Makefile.PL INSTALL_BASE=../modules
make
make install
popd

PERL5LIB=$(pwd)/modules/lib/perl5:$PERL5LIB ; export PERL5LIB
perl chef_compile.pl
