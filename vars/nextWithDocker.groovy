// def call(String DOCKER_USER, String DOCKER_PASS, String TAGS, String IMAGE_NAME) {
//     def dockerfileContent = libraryResource 'next.dockerfile'
//     writeFile file: 'Dockerfile', text: dockerfileContent
//     sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
//     sh 'docker build -t $DOCKER_USER/$IMAGE_NAME:$TAGS .'
//     sh 'docker push $DOCKER_USER/$IMAGE_NAME:$TAGS'
// }

def call(String DOCKER_TAG, String ImageName) {
    def dockerfileContent = libraryResource 'next.dockerfile'
    writeFile file: 'Dockerfile', text: dockerfileContent
    sh "docker build -t ${ImageName}:${DOCKER_TAG} ."
    sh "echo ${DOCKER_TAG}"
} 