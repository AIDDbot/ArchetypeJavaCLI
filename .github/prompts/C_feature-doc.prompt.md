---
description: 'Write documentation for a feature implementation'
---

# Feature Documentation

Write documentation for the feature: ${input:featureId}

## Context

- [{featureId}.design.md](/docs/feats/{featureId}.design.md)
- [Architecture Instructions](../instructions/bst_architecture.instructions.md)
- [STRUCTURE.md](/docs/STRUCTURE.md) (if exists)

## Workflow

- [ ] Add documentation comments to any public or exported functions, classes, or modules in the feature codebase.

- [ ] Read and follow the [tpl_docs-STRUCTURE](../instructions/tpl_docs-STRUCTURE.instructions.md) instructions

- [ ] Update or create the [docs/STRUCTURE.md](/docs/STRUCTURE.md) file to include the new feature.

- [ ] Update the [BACKLOG.md](/docs/BACKLOG.md) with:
  - [ ] change or keep the status to ✔️ RELEASED

- [ ] Commit changes by running [/U_git-commit](U_git-commit.prompt.md) with docs type message and closing the feature.

- [ ] Merge the branch named `feat/{featureId}` to `main` and switch to it.

You are not allowed to push nothing to remote.

## Validation

- [ ] [BACKLOG.md](/docs/BACKLOG.md) is updated with the feature test link and status

> End of Feature Documentation prompt.