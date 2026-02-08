@param String title = "Flagd demo"
@param dev.openfeature.sdk.Client client

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">${title}</h1>
        <p class="lead">Hello from JTE template!</p>
        
        <div class="card mb-4">
            <div class="card-header">Simple Boolean Flag</div>
            <div class="card-body">
                <p>Boolean Feature Toggle: <strong>${client.getBooleanValue("booleanFeatureToggle", false)}</strong></p>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">String Flags (Variants)</div>
            <div class="card-body">
                <p>Welcome Message (default): <strong>${client.getStringValue("welcomeMessage", "Fallback Hello")}</strong></p>
                <p>Promotional Banner: <strong>${client.getStringValue("promotionalBanner", "No promotion")}</strong></p>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">Number Flags</div>
            <div class="card-body">
                <p>Feature Limit: <strong>${client.getIntegerValue("featureLimit", 0)}</strong></p>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header">Flags with Evaluation Context</div>
            <div class="card-body">
                !{var premiumContext = new dev.openfeature.sdk.MutableContext();}
                !{premiumContext.add("user_tier", "premium");}
                <p>Welcome Message (Premium Tier): <strong>${client.getStringValue("welcomeMessage", "Fallback Hello", premiumContext)}</strong></p>
                
                !{var usContext = new dev.openfeature.sdk.MutableContext();}
                !{usContext.add("country", "US");}
                !{usContext.add("user_id", "user123");}
                <p>New UI Layout (US, user123): <strong>${client.getStringValue("newUILayout", "control", usContext)}</strong></p>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
