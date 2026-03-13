## GitHub Actions

**GitHub Actions** is a CI/CD tool built into GitHub that allows automated scripts to be ran on certain repository events (push to a branch, pulls from a branch, merges). This can be used to run automated tests, deploy code to production, etc.

The core building block is that of a **workflow**, defined by a script, whose automatic execution is triggered by an **event** related to our repository state or simply on a fixed schedule (i.e. nightly builds).

The feature is free for public repositories and paid for private repositories. You may elect to run Actions on your own hardware to save on costs.

### YAML

**YAML** (_Yet Another Markup Language_ or _YAML Ain't Markup Language_) is essentially the Python syntax equivalent of JSON, preferring colons and indentation over nested braces for defining key-value pairs.

For our use case, our GitHub Actions workflows will be written in YAML. Store them with file extension `.yml`.

### Workflow Layout

Within your GitHub repository, store your YAML files in the `.github/workflows` directory.

The basic structure of a workflow is as follows:

- At the top, define the **name** of your workflow.**
- Next include when to run the workflow with **on**.
- Include any variables to use with **env**.
- Then, detail the **jobs** to perform.
    - Each job contains the context (what kind of machine to run on) with the **runs-on** keyword.
    - Each job has a series of **steps** that are sequentially-executed.

```YAML
# The name of your workflow
name: Workflow Name

# The naming template for a specific run of the workflow
# By default, auto-generated based on action (push/pull)
run-name: @${{ github.actor }}'s deployment

# When to run this workflow?
on:
    # Run it on a push request to the main branch
    push:
        branches: [ "main" ]

    # Also run it on a pull request to the main or master branches
    pull_request:
        branches: [ "main", "master" ]

    # Allow the workflow to be manually triggered from the GitHub Actions page
    workflow_dispatch:

# Define variables to reference in the workflow
env:
    LIFE: 42

# What actions to perform in the workflow?
jobs:
    # A name for your job
    my_first_job:
        # The machine to run on: a Linux VM with the Ubuntu distro
        runs-on: ubuntu-latest

        # The sequential steps for this job
        steps:
            # Step name
            - name: Do something
              # Execute the following command in the shell
              run: ls

            # Clones the repo code to the instance
            - name: Checkout Repo
              uses: actions/checkout@v6

            # Use a pre-defined action
            - name: Installs Node
              uses: actions/setup-node@v6.3.0
              with:
                    node-version: "26"

            - name: Installs dependencies
              run: npm i

            - name: Run tests
              run: npm run test

    my_second_job:
        ...
        # Runs only on the success of my_first_job
        needs: [ "my_first_job" ]

```

#### Some Notes

 - By default, the instance that a job is spun up on doesn't contain anything. Use the `actions/checkout` action to clone your repo there.
 - From there, the working directory will be the base of your repository (where your `.git` file is located)
 - Jobs are by default spun up on separate machines and run in parallel. In order to define dependencies, use the `needs` key.

Reference: https://docs.github.com/en/actions/reference/workflows-and-actions/workflow-syntax

### Actions

GitHub allows the exporting of reusable scripts called **Actions** for you or others to reuse. To leverage this, view the **GitHub Marketplace** on the right side of editing an action flow.

Here, you can find
To use an action, use the `uses` key in one of your steps.
Any additional config is defined with the `with` keyword alongside its respective key-value pair. Marketplace actions generally come with their own documentation that further elaborates on usage and configuration.

Example:

```YAML
uses: actions/setup-node@v6.3.0
with:
      node-version: "26"
```

Reference: https://docs.github.com/en/actions/get-started/understand-github-actions

### GitHub Secrets

We sometimes need to include sensitive, private information (API keys, authentication keys) for our workflow functionality. Obviously, we don't want to put these in plain text in our workflow definitions.

Instead, we use **GitHub Secrets** to define key-value pairs within the settings -> security tab of our repo.

Afterwards, reference our secret in our YAML file using:

```
${{ secrets.MySecretName }}
```