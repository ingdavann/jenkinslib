def call(String DOCKER_USER,String DOCKER_PASS,String TAGS, String IMAGE_NAME) {
    try {
        // Validate required parameters
        if (!TAGS || !IMAGE_NAME) {
            throw new IllegalArgumentException("Missing required parameters for Docker.")
        }

        // Docker build
        sh "docker build -t ${DOCKER_USER}/${IMAGE_NAME}:${TAGS} ."

        // Docker login (if required - uncomment and provide credentials)
        sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"

        // Docker push (if required - uncomment)
        sh "docker push ${DOCKER_USER}/${IMAGE_NAME}:${TAGS}"
    } catch (Exception e) {
        echo "An error occurred: ${e.message}"
        currentBuild.result = 'FAILURE'
        error("Pipeline failed due to an error.")   
    }       
}


