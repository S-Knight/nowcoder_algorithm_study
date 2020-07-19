<?php


class Solution
{
    private $num = 0;

    private $a = [];

    private $b = [];

    public function __construct()
    {
        $this->getInput();
    }

    private function getInput()
    {
        if (fscanf(STDIN, "%d", $this->num) == 1) {
            fscanf(STDIN, "%[^\n]s", $line);

            $this->a = explode(" ", trim($line));
        }
    }

    public function getB()
    {
        for ($i = $this->num - 1; $i >= 0; $i -= 2) {
            $this->b[] = $this->a[$i];
        }

        if ($this->num % 2 == 0) {
            $start = 0;
        } else {
            $start = 1;
        }

        for ($i = $start; $i < $this->num; $i += 2) {
            $this->b[] = $this->a[$i];
        }

        return $this->b;
    }
}

$solution = new Solution();
$b = $solution->getB();

$bLength = count($b);
for ($i = 0; $i < $bLength; $i++) {
    echo $b[$i];

    if ($i != $bLength - 1) {
        echo " ";
    } else {
        echo "\n";
    }
}