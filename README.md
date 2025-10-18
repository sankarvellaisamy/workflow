Base Problem Statement: Design and implement an approval service for an expense review system. Users submit documents, which go through a multi-stage approval workflow (e.g., manager review → finance check → final sign-off). The system should handle creation/approvals/rejections and track status.

Core requirements
Create/submit a Request with metadata (requester, category, tenantId, and request meta data like amount and so on)

Define workflow templates with ordered or conditional steps (role-based: Manager, Finance, Legal).
Approvers receive tasks; they can approve/reject with comments.
Transition a request through steps: Ex: PENDING → IN_REVIEW → APPROVED/REJECTED.


Given a workflow system should give a proper status
Declarative workflow representation (e.g., JSON/YAML spec) and validation.

Clear domain models
