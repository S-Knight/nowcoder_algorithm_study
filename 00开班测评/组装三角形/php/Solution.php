<?php

class Solution
{
    private $num = 0;

    private $lengths = [];

    public function __construct()
    {
        $this->getInput();
    }

    private function getInput()
    {
        if (fscanf(STDIN, "%d", $this->num) == 1) {
            fscanf(STDIN, "%[^\n]s", $line);

            $this->lengths = explode(" ", trim($line));
            sort($this->lengths);
        }
    }

    public function getSolutionCount()
    {
        $count = 0;

        for ($i = 0; $i < $this->num - 2; $i++) {
            for ($j = $i + 1; $j < $this->num - 1; $j++) {
                for ($k = $j + 1; $k < $this->num; $k++) {
                    if ($this->lengths[$k] >= $this->lengths[$i] + $this->lengths[$j]) {
                        break;
                    }

                    $count++;
                }
            }
        }

        return $count;
    }
}

$solution = new Solution();
echo $solution->getSolutionCount() . "\n";