FROM    debian:jessie

MAINTAINER Yen-Chin, Lee <coldnew.tw@gmail.com>

# Timezon
ENV TZ="/usr/share/zoneinfo/Asia/Taipei"

RUN apt-get update -y
RUN apt-get install -qqy wget unzip curl sqlite3 tzdata ca-certificates

# timezone
RUN echo 'Asia/Taipei'  | tee /etc/timezone
RUN dpkg-reconfigure --frontend noninteractive tzdata

# Install java runtime
RUN curl -O https://raw.githubusercontent.com/rednoah/java-installer/master/release/get-java.sh && \
    sh get-java.sh install

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# We use root previledge for leinigen
ENV LEIN_ROOT=1

# Install leinigen
RUN wget -q -O /usr/bin/lein \
    https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
    && chmod +x /usr/bin/lein

# Define working directory.
WORKDIR /data

COPY entrypoint.sh /sbin/entrypoint.sh
RUN chmod 755 /sbin/entrypoint.sh
ENTRYPOINT ["/sbin/entrypoint.sh"]
