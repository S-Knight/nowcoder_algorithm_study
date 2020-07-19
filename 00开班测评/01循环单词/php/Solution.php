<?php

class Solution
{
    private $wordsCount = 0;

    private $words = [];

    public function __construct()
    {
        $this->getInput();
    }

    private function getInput()
    {
        if (fscanf(STDIN, "%d", $this->wordsCount) == 1) {
            for ($i = 0; $i < $this->wordsCount; $i++) {
                fscanf(STDIN, "%[^\n]s", $line);
                $this->words[] = $line;
            }
        }
    }

    public function getCirWordsCount()
    {
        /*for ($i = 0; $i < $this->wordsCount; $i++) {
        }*/

        for($i=0; $i<strlen($this->words[0]); $i++){
            echo substr($this->words[0], $i) . substr($this->words[0], 0, $i);
            echo "\n";
        }

        return 0;
    }
}

$solution = new Solution();
echo $solution->getCirWordsCount() . "\n";