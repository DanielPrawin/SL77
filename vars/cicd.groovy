def newGit(repo)
{
  git "https://github.com/DanielPrawin/${repo}.git"
}
def build()
{
   sh "mvn package"
}
def deploy(jobName,ip,context)
{
    sh "scp /var/lib/jenkins/workspace/${jobName}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${context}.war"
}
def testing(testing){
    sh "java -jar /var/lib/jenkins/workspace/ScriptedPipeLine/${testing}.jar"
}
