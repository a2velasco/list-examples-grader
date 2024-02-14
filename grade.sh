CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

if [[ -f student-submission/ListExamples.java ]]
then
    echo "File found."
else
    echo "File not found."
    exit
fi

cp student-submission/ListExamples.java TestListExamples.java grading-area
cp -r lib grading-area

cd grading-area
javac -cp $CPATH *.java

if [[ $? -eq 0 ]]
then
    echo "Compilation successful."
else
    echo "Compilation not successful."
    exit
fi 

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > test-results.txt

grep -h "OK" test-results.txt
if [[ $? -ne 0 ]]
then    
    grep -h "Tests run:" test-results.txt
    echo "Did not pass all tests. Try again!"
else
    echo "Congrats you pass!"
fi