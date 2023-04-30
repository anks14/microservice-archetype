#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
FROM amazoncorretto:17-alpine-jdk
COPY target/*.jar ${artifactId}.jar
ADD run.sh /run.sh
RUN chmod a+x /run.sh
ENTRYPOINT ["/run.sh"]