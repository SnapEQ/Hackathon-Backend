# GitHub Actions Workflows

This directory contains automated workflows for maintaining code quality and preventing merge conflicts.

## Workflows

### 1. PR Review and Merge Conflict Check (`pr-review.yml`)

**Purpose:** Automatically checks pull requests for merge conflicts and provides helpful feedback.

**Triggers:**
- When a PR is opened
- When new commits are pushed to a PR
- When a PR is reopened

**Features:**
- ✅ Automatic merge conflict detection
- 📝 Automated comments with conflict resolution instructions
- 🏷️ Adds/removes `merge-conflict` label
- ✔️ Status checks for PR mergeability
- 📋 Posts a review checklist for contributors

**What it does:**
1. Fetches the base branch and attempts a test merge
2. Detects if there are any merge conflicts
3. Posts a comment on the PR with:
   - List of conflicting files (if any)
   - Step-by-step resolution instructions
   - Current merge status
4. Updates the comment as the PR changes
5. Adds/removes labels to help track conflict status

### 2. Code Quality and Review (`code-quality.yml`)

**Purpose:** Provides automated code review insights to help reviewers.

**Triggers:**
- When a PR is opened or updated against `main` or `develop` branches

**Features:**
- 📊 PR size analysis (small/medium/large)
- 📈 Statistics on files changed and lines modified
- ⚠️ Detection of potential issues (large files, etc.)
- 💡 Recommendations for PR improvements

**What it does:**
1. Analyzes the PR size and complexity
2. Counts files changed and total line modifications
3. Posts analysis with size indicators:
   - 🟢 Small: < 200 lines changed
   - 🟡 Medium: 200-500 lines changed
   - 🔴 Large: > 500 lines changed
4. Flags potential issues for reviewer attention

## Benefits for Collaborative Development

### Prevents Merge Conflicts
- **Early Detection:** Catches merge conflicts as soon as they occur
- **Clear Instructions:** Provides step-by-step resolution guidance
- **Automatic Re-checks:** Re-validates after each push

### Improves Code Review Process
- **Review Planning:** Size analysis helps reviewers allocate time
- **Quality Standards:** Checklist ensures consistent review criteria
- **Better Collaboration:** Clear communication between team members

### Status Checks
Both workflows create status checks that can be configured as required checks for branch protection, ensuring:
- No merge conflicts before merging
- Code review process is followed

## Configuration

### Making Status Checks Required

To make these checks required before merging:

1. Go to repository Settings → Branches
2. Add a branch protection rule for your main branch
3. Enable "Require status checks to pass before merging"
4. Select the following checks:
   - `Merge Conflict Check`
   - `Code Quality Review`

### Customization

You can customize the workflows by editing the YAML files:

- **Change PR size thresholds:** Edit the line count thresholds in `code-quality.yml`
- **Modify labels:** Change the label name/color in `pr-review.yml`
- **Add more checks:** Extend the workflows with additional validation steps

## Example Usage

When you or your friend create a pull request:

1. **Automatic Check Runs:**
   - Merge conflict check executes immediately
   - Code quality analysis runs in parallel

2. **PR Comments:**
   - Review checklist is posted (first time only)
   - Conflict status is commented (updated on each push)
   - Size analysis shows PR complexity

3. **Visual Indicators:**
   - Labels show conflict status at a glance
   - Status checks show pass/fail in PR view
   - Emoji indicators make scanning easy

4. **Conflict Resolution:**
   - If conflicts exist, detailed instructions are provided
   - After resolving and pushing, checks automatically re-run
   - Labels and status update automatically

## Troubleshooting

**Workflow not running?**
- Check that the PR targets the correct base branch
- Ensure GitHub Actions is enabled in repository settings

**Status checks not appearing?**
- May take a few minutes on first run
- Check the Actions tab for execution logs

**Permissions issues?**
- Verify the repository has Actions permissions enabled
- Check that the workflow has appropriate `permissions` set

## Future Enhancements

Possible additions:
- Code style linting
- Test coverage reports
- Security vulnerability scanning
- Automatic assignment of reviewers
- Integration with external code review tools
