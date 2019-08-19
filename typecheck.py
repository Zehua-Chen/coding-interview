from argparse import ArgumentParser
from subprocess import Popen
import sys

parser = ArgumentParser()

parser.add_argument(
    "--name",
    help="name of the problem to typecheck",
    type=str)

args = parser.parse_args()

problem_path = "problems/{}".format(args.name)
mypy_process = Popen(["mypy", problem_path, "--strict"])

mypy_process.wait()
print(mypy_process.stdout)
